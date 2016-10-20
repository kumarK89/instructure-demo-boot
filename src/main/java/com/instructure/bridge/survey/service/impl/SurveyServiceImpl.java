package com.instructure.bridge.survey.service.impl;


import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.domain.User;
import com.instructure.bridge.survey.adapter.SurveyAdapter;
import com.instructure.bridge.survey.service.GetSurveyRequest;
import com.instructure.bridge.survey.service.GetSurveyResponse;
import com.instructure.bridge.survey.service.api.SurveyService;
import com.instructure.bridge.survey.service.utils.SurveyServiceConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SurveyServiceImpl implements SurveyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyServiceImpl.class);

    private final SurveyAdapter surveyAdapter;

    private final SurveyServiceConverter surveyServiceConverter;

    public SurveyServiceImpl(SurveyAdapter surveyAdapter,
                             SurveyServiceConverter surveyServiceConverter) {
        this.surveyAdapter = surveyAdapter;
        this.surveyServiceConverter = surveyServiceConverter;
    }

    @Override
    public GetSurveyResponse getSurveyQuestions(GetSurveyRequest getSurveyRequest) {
        List<SurveyQuestions> surveyQuestionses = surveyAdapter
                .getSurveyQuestions(getSurveyRequest.getSrvyId());
        surveyQuestionses.forEach(surveyQuestionsDto ->
                surveyQuestionsDto.setSurveyQuestionOptionses
                        (surveyAdapter.getSurveyOptions(surveyQuestionsDto.getSrvyQtnId())));
        return surveyServiceConverter.getSurveyResponseForSurveyQuestions(surveyQuestionses);
    }

    @Override
    public GetSurveyResponse getUserSurveyDetails(GetSurveyRequest getSurveyRequest) {
        User user = surveyAdapter.getAssignedSurveysForUser(getSurveyRequest.getUserId());
        return surveyServiceConverter.getSurveyResponseForSurveys(user.getSurveys());
    }

    @Override
    public void submitSurvey(GetSurveyRequest getSurveyRequest) {
        Integer usrSrvyMpngId = surveyAdapter
                .getUserSrvyMpngRcrd(getSurveyRequest.getUserId(), getSurveyRequest.getSrvyId());
        surveyAdapter.submitSurvey(getSurveyRequest.getSurveyQuestions(), usrSrvyMpngId);
    }

    @Override
    public GetSurveyResponse getUserSurveyQustions(GetSurveyRequest getSurveyRequest) {
        List<SurveyQuestions> surveyQuestionses = surveyAdapter.getUserSurveyQustions
                (getSurveyRequest.getUserId(), getSurveyRequest.getSrvyId());
        return surveyServiceConverter.getSurveyResponseForSurveyQuestions(surveyQuestionses);
    }

}
