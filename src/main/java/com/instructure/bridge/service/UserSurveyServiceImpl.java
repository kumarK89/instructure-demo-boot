package com.instructure.bridge.service;

import com.instructure.bridge.dao.UserSurveyDao;
import com.instructure.bridge.utils.ModelMapperUtil;
import com.instructure.bridge.utils.ReplaceNull;

import org.jooq.Record;
import org.jooq.Record5;
import org.jooq.Record6;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jooq.codgen.tables.records.InstrUsrSrvyQtnOptRecord;

public class UserSurveyServiceImpl implements UserSurveyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSurveyServiceImpl.class);

    private final UserSurveyDao userSurveyDao;

    public UserSurveyServiceImpl(UserSurveyDao userSurveyDao) {
        this.userSurveyDao = userSurveyDao;
    }

    @Override
    @Transactional
    public User getUserSurveyDetails(int userId) {
        LOGGER.debug("In getUserSurveyDetails for userId- {}", userId);
        User user = null;
        List<Record6<Integer, String, Integer,
                String, Date, Date>> result = userSurveyDao.getAssignedSurveysForUser(userId);
        if (!result.isEmpty()) {
            ModelMapper modelMapper = ModelMapperUtil.MODEL_MAPPER;
            user = modelMapper.map(result.get(0), User.class);
            user.setSurveys(result.stream()
                    .map(record -> getSurveyDto(record, modelMapper))
                    .collect(Collectors.toList()));
        }
        return user;
    }

    @Override
    @Transactional
    public void submitSurvey(Integer usrId, Integer srvyId,
                             List<SurveyQuestions> surveyQuestionses) {
        LOGGER.debug("In submitSurvey for userId- {} srvyId- {}", usrId, srvyId);
        Integer usrSrvyMpngId = userSurveyDao
                .getUserSrvyMpngRcrd(usrId, srvyId).getUsrSrvyMpngId();
        List<InstrUsrSrvyQtnOptRecord> usrSrvyQtnOptRecords = new ArrayList<>();
        surveyQuestionses.forEach(surveyQuestionsDto ->
                surveyQuestionsDto.getSurveyQuestionOptionses().
                        forEach(surveyQuestionOptions -> {
                            InstrUsrSrvyQtnOptRecord usrSrvyQtnOptRecord =
                                    new InstrUsrSrvyQtnOptRecord();
                            usrSrvyQtnOptRecord.setSrvyQtnId(
                                    surveyQuestionsDto.getSrvyQtnId());
                            usrSrvyQtnOptRecord.setSrvyQtnOptId(
                                    surveyQuestionOptions.getSrvyQtnOptId());
                            usrSrvyQtnOptRecord.setUsrSrvyMpngId(usrSrvyMpngId);
                            usrSrvyQtnOptRecords.add(usrSrvyQtnOptRecord);
                        })
        );
        userSurveyDao.submitSurvey(usrSrvyQtnOptRecords);

    }

    @Override
    public List<SurveyQuestions> getUserSurveyQustions(Integer usrId, Integer srvyId) {
        LOGGER.debug("In getUserSurveyQustions for userId- {} srvyId- {}", usrId, srvyId);
        final List<SurveyQuestions> surveyQuestionses = new ArrayList<>();
        List<Record5<String, Integer, Integer, String, Boolean>> surveyQtnLst = userSurveyDao
                .getUserSurveyQustions(usrId, srvyId);
        if (!surveyQtnLst.isEmpty()) {
            int indx = 0;
            SurveyQuestions surveyQuestions = null;
            List<SurveyQuestionOptions> surveyQuestionOptionses = null;
            for (Record5<String, Integer, Integer, String, Boolean> record : surveyQtnLst) {
                if (indx == 0 ||
                        (surveyQuestions != null &&
                                !record.value2().equals(surveyQuestions.getSrvyQtnId()))) {
                    surveyQuestions = new SurveyQuestions();
                    surveyQuestions.setQtnTxt(record.value1());
                    surveyQuestions.setSrvyQtnId(record.value2());
                    surveyQuestionOptionses = new ArrayList<>();
                    surveyQuestionOptionses.add(setSurveyQuestionOptionsDto(record));
                    surveyQuestions.setSurveyQuestionOptionses(surveyQuestionOptionses);
                    surveyQuestionses.add(surveyQuestions);
                } else {
                    surveyQuestionOptionses = ReplaceNull
                            .withEmptyList(surveyQuestionOptionses);
                    surveyQuestionOptionses.add(setSurveyQuestionOptionsDto(record));
                }
                indx++;
            }
        }
        return surveyQuestionses;
    }

    private SurveyQuestionOptions setSurveyQuestionOptionsDto
            (Record5<String, Integer, Integer, String, Boolean> record) {
        SurveyQuestionOptions surveyQuestionOptions = new SurveyQuestionOptions();
        surveyQuestionOptions.setSrvyQtnOptId(record.value3());
        surveyQuestionOptions.setOptText(record.value4());
        surveyQuestionOptions.setOptionSelected(record.value5());
        return surveyQuestionOptions;
    }

    private Survey getSurveyDto(Record record, ModelMapper modelMapper) {
        return modelMapper.map(record, Survey.class);
    }
}