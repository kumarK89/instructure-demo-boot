package com.instructure.bridge.survey.service;

import com.instructure.bridge.survey.domain.Survey;
import com.instructure.bridge.survey.domain.SurveyQuestions;

import java.util.List;

public class GetSurveyResponse {

    List<Survey> surveys;

    List<SurveyQuestions> surveyQuestionses;

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public List<SurveyQuestions> getSurveyQuestionses() {
        return surveyQuestionses;
    }

    public void setSurveyQuestionses(List<SurveyQuestions> surveyQuestionses) {
        this.surveyQuestionses = surveyQuestionses;
    }
}
