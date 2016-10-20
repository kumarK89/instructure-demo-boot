package com.instructure.bridge.survey.adapter.utils;

import com.instructure.bridge.survey.adapter.entity.tables.records.InstrSrvyQtnOptsRecord;
import com.instructure.bridge.survey.adapter.entity.tables.records.InstrSrvyQtnsRecord;
import com.instructure.bridge.survey.adapter.entity.tables.records.InstrUsrSrvyQtnOptRecord;
import com.instructure.bridge.survey.domain.Survey;
import com.instructure.bridge.survey.domain.SurveyQuestionOptions;
import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.domain.User;

import org.jooq.Record5;
import org.jooq.Record6;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.jooq.RecordValueReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SurveyAdapterConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyAdapterConverter.class);

    private ModelMapper modelMapper;

    public SurveyAdapterConverter() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().addValueReader(new RecordValueReader());
        modelMapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
    }

    public List<SurveyQuestions> convertQtnRcrds(
            List<InstrSrvyQtnsRecord> instrSrvyQtnsRecords) {
        List<SurveyQuestions> surveyQuestionses = instrSrvyQtnsRecords.stream()
                .map(srvyQtnsRecord -> modelMapper.map(srvyQtnsRecord
                        , SurveyQuestions.class)).collect(Collectors.toList());
        return surveyQuestionses;
    }

    public List<SurveyQuestionOptions> convertOptnRcrds
            (List<InstrSrvyQtnOptsRecord> srvyQtnOptsRecords) {
        return srvyQtnOptsRecords.stream()
                .map(srvyQtnOptsRecord -> modelMapper.map(srvyQtnOptsRecord
                        , SurveyQuestionOptions.class)).collect(Collectors.toList());
    }

    public User covertRecord6Rcrds
            (List<Record6<Integer, String, Integer, String, Date, Date>> record6List) {
        User user = null;
        user = modelMapper.map(record6List.get(0), User.class);
        user.setSurveys(record6List.stream()
                .map(record -> modelMapper.map(record, Survey.class))
                .collect(Collectors.toList()));
        return user;
    }

    public List<SurveyQuestions> covertRecord5Rcrds
            (List<Record5<String, Integer, Integer, String, Boolean>> record5List) {
        List<SurveyQuestions> surveyQuestionses = new ArrayList<>();
        int indx = 0;
        SurveyQuestions surveyQuestions = null;
        List<SurveyQuestionOptions> surveyQuestionOptionses = null;
        for (Record5<String, Integer, Integer, String, Boolean> record : record5List) {
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
                surveyQuestionOptionses = surveyQuestionOptionses == null ?
                        Collections.EMPTY_LIST : surveyQuestionOptionses;
                surveyQuestionOptionses.add(setSurveyQuestionOptionsDto(record));
            }
            indx++;
        }
        return surveyQuestionses;
    }

    public List<InstrUsrSrvyQtnOptRecord> convertSurveyQuestions
            (List<SurveyQuestions> surveyQuestionses, Integer usrSrvyMpngId) {
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
        return usrSrvyQtnOptRecords;
    }

    private SurveyQuestionOptions setSurveyQuestionOptionsDto
            (Record5<String, Integer, Integer, String, Boolean> record) {
        SurveyQuestionOptions surveyQuestionOptions = new SurveyQuestionOptions();
        surveyQuestionOptions.setSrvyQtnOptId(record.value3());
        surveyQuestionOptions.setOptText(record.value4());
        surveyQuestionOptions.setOptionSelected(record.value5());
        return surveyQuestionOptions;
    }
}
