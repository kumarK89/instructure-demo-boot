package com.instructure.bridge.survey.service;

import com.instructure.bridge.survey.domain.SurveyQuestions;

import java.util.List;

public class GetSurveyRequest {

    private int userId;
    private int srvyId;
    private List<SurveyQuestions> surveyQuestions;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSrvyId() {
        return srvyId;
    }

    public void setSrvyId(int srvyId) {
        this.srvyId = srvyId;
    }

    public List<SurveyQuestions> getSurveyQuestions() {
        return surveyQuestions;
    }

    public void setSurveyQuestions(List<SurveyQuestions> surveyQuestions) {
        this.surveyQuestions = surveyQuestions;
    }
}
