package com.instructure.service;

import com.instructure.dao.SurveyDao;
import com.instructure.dto.SurveyQuestionOptionsDto;
import com.instructure.dto.SurveyQuestionsDto;
import com.instructure.utils.ModelMapperUtil;

import java.util.List;
import java.util.stream.Collectors;

import jooq.codgen.tables.records.InstrSrvyQtnOptsRecord;
import jooq.codgen.tables.records.InstrSrvyQtnsRecord;

public class SurveyServiceImpl implements SurveyService {

    private final SurveyDao surveyDao;

    public SurveyServiceImpl(SurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

    @Override
    public List<SurveyQuestionsDto> getSurveyQuestions(Integer srvyId) {
        List<SurveyQuestionsDto> surveyQuestionsDtos = null;
        List<InstrSrvyQtnsRecord> srvyQtnsRecords = surveyDao.getSurveyQuestions(srvyId);
        if (!srvyQtnsRecords.isEmpty()) {
            surveyQuestionsDtos = srvyQtnsRecords.stream()
                    .map(srvyQtnsRecord -> ModelMapperUtil.MODEL_MAPPER.map(srvyQtnsRecord
                            , SurveyQuestionsDto.class)).collect(Collectors.toList());
            surveyQuestionsDtos.forEach(surveyQuestionsDto ->
                    surveyQuestionsDto.setSurveyQuestionOptionsDtos(
                            getSurveyQuestionOptionsDtos(surveyQuestionsDto.getSrvyQtnId())));
        }
        return surveyQuestionsDtos;
    }


    private List<SurveyQuestionOptionsDto> getSurveyQuestionOptionsDtos(Integer srvyQtnId) {
        List<SurveyQuestionOptionsDto> surveyQuestionOptionsDtos = null;
        List<InstrSrvyQtnOptsRecord> srvyQtnOptsRecords = surveyDao.getSurveyOptions(srvyQtnId);
        if (!srvyQtnOptsRecords.isEmpty()) {
            surveyQuestionOptionsDtos = srvyQtnOptsRecords.stream()
                    .map(srvyQtnOptsRecord -> ModelMapperUtil.MODEL_MAPPER.map(srvyQtnOptsRecord
                            , SurveyQuestionOptionsDto.class)).collect(Collectors.toList());
        }
        return surveyQuestionOptionsDtos;
    }
}
