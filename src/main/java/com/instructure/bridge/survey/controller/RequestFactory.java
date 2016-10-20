package com.instructure.bridge.survey.controller;


import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.service.GetSurveyRequest;

import java.util.List;

public class RequestFactory {

    public GetSurveyRequest getSurveyRequestForUserId
            (int userId, int srvyId, List<SurveyQuestions> surveyQuestionses) {
        GetSurveyRequest getSurveyRequest = new GetSurveyRequest();
        getSurveyRequest.setUserId(userId);
        getSurveyRequest.setSrvyId(srvyId);
        getSurveyRequest.setSurveyQuestions(surveyQuestionses);
        return getSurveyRequest;
    }
}
