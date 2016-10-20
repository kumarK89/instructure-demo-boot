package com.instructure.bridge.survey.service.utils;

import com.instructure.bridge.survey.domain.Survey;
import com.instructure.bridge.survey.domain.SurveyQuestionOptions;
import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.service.GetSurveyResponse;

import java.util.List;

public class SurveyServiceConverter {

    public GetSurveyResponse getSurveyResponseForSurveyQuestions
            (List<SurveyQuestions> surveyQuestionses) {
        GetSurveyResponse getSurveyResponse = new GetSurveyResponse();
        getSurveyResponse.setSurveyQuestionses(surveyQuestionses);
        return getSurveyResponse;
    }

    public GetSurveyResponse getSurveyResponseForSurveys(List<Survey> surveys) {
        GetSurveyResponse getSurveyResponse = new GetSurveyResponse();
        getSurveyResponse.setSurveys(surveys);
        return getSurveyResponse;
    }
}
