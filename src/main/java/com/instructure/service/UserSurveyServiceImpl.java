package com.instructure.service;

import com.instructure.dao.UserSurveyDao;
import com.instructure.db.tables.records.InstrUsrSrvyQtnOptRecord;
import com.instructure.dto.SurveyDto;
import com.instructure.dto.SurveyQuestionOptionsDto;
import com.instructure.dto.SurveyQuestionsDto;
import com.instructure.dto.UserDto;
import com.instructure.utils.ModelMapperUtil;

import org.jooq.Record;
import org.jooq.Record5;
import org.jooq.Record6;
import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserSurveyServiceImpl implements UserSurveyService {

    private final UserSurveyDao userSurveyDao;

    public UserSurveyServiceImpl(UserSurveyDao userSurveyDao) {
        this.userSurveyDao = userSurveyDao;
    }

    @Override
    public UserDto getUserSurveyDetails(int userId) {
        return getUserDtoFromListOfRecords(userSurveyDao.getAssignedSurveysForUser(userId));
    }

    @Override
    public void submitSurvey(Integer usrId, Integer srvyId,
                             List<SurveyQuestionsDto> surveyQuestionsDtos) {
        Integer usrSrvyMpngId = userSurveyDao
                .getUserSrvyMpngRcrd(usrId, srvyId).getUsrSrvyMpngId();
        List<InstrUsrSrvyQtnOptRecord> usrSrvyQtnOptRecords = new ArrayList<>();
        surveyQuestionsDtos.forEach(surveyQuestionsDto ->
                surveyQuestionsDto.getSurveyQuestionOptionsDtos().
                        forEach(surveyQuestionOptionsDto -> {
                            InstrUsrSrvyQtnOptRecord usrSrvyQtnOptRecord =
                                    new InstrUsrSrvyQtnOptRecord();
                            usrSrvyQtnOptRecord.setSrvyQtnId(
                                    surveyQuestionsDto.getSrvyQtnId());
                            usrSrvyQtnOptRecord.setSrvyQtnOptId(
                                    surveyQuestionOptionsDto.getSrvyQtnOptId());
                            usrSrvyQtnOptRecord.setUsrSrvyMpngId(usrSrvyMpngId);
                            usrSrvyQtnOptRecords.add(usrSrvyQtnOptRecord);
                        })
        );
        userSurveyDao.submitSurvey(usrSrvyQtnOptRecords);

    }

    @Override
    public List<SurveyQuestionsDto> getUserSurveyQustions(Integer usrId, Integer srvyId) {
        final List<SurveyQuestionsDto> surveyQuestionsDtos = new ArrayList<>();
        List<Record5<String, Integer, Integer, String, Boolean>> surveyQtnLst = userSurveyDao
                .getUserSurveyQustions(usrId, srvyId);
        if (!surveyQtnLst.isEmpty()) {
            int indx = 0;
            SurveyQuestionsDto surveyQuestionsDto = null;
            List<SurveyQuestionOptionsDto> surveyQuestionOptionsDtos = null;
            for (Record5<String, Integer, Integer, String, Boolean> record : surveyQtnLst) {
                if (indx == 0 || !record.value2().equals(surveyQuestionsDto.getSrvyQtnId())) {
                    surveyQuestionsDto = new SurveyQuestionsDto();
                    surveyQuestionsDto.setQtnTxt(record.value1());
                    surveyQuestionsDto.setSrvyQtnId(record.value2());
                    surveyQuestionOptionsDtos = new ArrayList<>();
                    surveyQuestionOptionsDtos.add(setSurveyQuestionOptionsDto(record));
                    surveyQuestionsDto.setSurveyQuestionOptionsDtos(surveyQuestionOptionsDtos);
                    surveyQuestionsDtos.add(surveyQuestionsDto);
                } else {
                    surveyQuestionOptionsDtos.add(setSurveyQuestionOptionsDto(record));
                }
                indx++;
            }
        }
        return surveyQuestionsDtos;
    }

    private SurveyQuestionOptionsDto setSurveyQuestionOptionsDto
            (Record5<String, Integer, Integer, String, Boolean> record) {
        SurveyQuestionOptionsDto surveyQuestionOptionsDto = new SurveyQuestionOptionsDto();
        surveyQuestionOptionsDto.setSrvyQtnOptId(record.value3());
        surveyQuestionOptionsDto.setOptText(record.value4());
        surveyQuestionOptionsDto.setOptionSelected(record.value5());
        return surveyQuestionOptionsDto;
    }

    private UserDto getUserDtoFromListOfRecords(List<Record6<Integer, String, Integer,
            String, Date, Date>> result) {
        UserDto userDto = null;
        if (!result.isEmpty()) {
            ModelMapper modelMapper = ModelMapperUtil.MODEL_MAPPER;
            userDto = modelMapper.map(result.get(0), UserDto.class);
            userDto.setSurveyDtos(result.stream()
                    .map(record -> getSurveyDto(record, modelMapper))
                    .collect(Collectors.toList()));
        }
        return userDto;
    }

    private SurveyDto getSurveyDto(Record record, ModelMapper modelMapper) {
        return modelMapper.map(record, SurveyDto.class);
    }
}