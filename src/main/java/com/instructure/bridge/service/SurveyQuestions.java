package com.instructure.bridge.service;

import java.util.List;

public class SurveyQuestions {

    private Integer srvyQtnId;
    private String qtnTxt;
    private List<SurveyQuestionOptions> surveyQuestionOptionses;

    public Integer getSrvyQtnId() {
        return srvyQtnId;
    }

    public void setSrvyQtnId(Integer srvyQtnId) {
        this.srvyQtnId = srvyQtnId;
    }

    public String getQtnTxt() {
        return qtnTxt;
    }

    public void setQtnTxt(String qtnTxt) {
        this.qtnTxt = qtnTxt;
    }

    public List<SurveyQuestionOptions> getSurveyQuestionOptionses() {
        return surveyQuestionOptionses;
    }

    public void setSurveyQuestionOptionses(
            List<SurveyQuestionOptions> surveyQuestionOptionses) {
        this.surveyQuestionOptionses = surveyQuestionOptionses;
    }
}
