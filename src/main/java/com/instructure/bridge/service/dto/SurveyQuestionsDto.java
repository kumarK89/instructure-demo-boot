package com.instructure.bridge.service.dto;

import java.util.List;

public class SurveyQuestionsDto {

    private Integer srvyQtnId;
    private String qtnTxt;
    private List<SurveyQuestionOptionsDto> surveyQuestionOptionsDtos;

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

    public List<SurveyQuestionOptionsDto> getSurveyQuestionOptionsDtos() {
        return surveyQuestionOptionsDtos;
    }

    public void setSurveyQuestionOptionsDtos(
            List<SurveyQuestionOptionsDto> surveyQuestionOptionsDtos) {
        this.surveyQuestionOptionsDtos = surveyQuestionOptionsDtos;
    }
}
