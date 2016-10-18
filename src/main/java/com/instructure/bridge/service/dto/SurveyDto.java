package com.instructure.bridge.service.dto;

import java.sql.Date;
import java.util.List;

public class SurveyDto {

    private Integer srvyId;
    private String srvyName;
    private Date srvyStrtDt;
    private Date srvyEndDt;

    private List<SurveyQuestionsDto> surveyQuestionsDtos;

    public Integer getSrvyId() {
        return srvyId;
    }

    public void setSrvyId(Integer srvyId) {
        this.srvyId = srvyId;
    }

    public String getSrvyName() {
        return srvyName;
    }

    public void setSrvyName(String srvyName) {
        this.srvyName = srvyName;
    }

    public Date getSrvyStrtDt() {
        return srvyStrtDt;
    }

    public void setSrvyStrtDt(Date srvyStrtDt) {
        this.srvyStrtDt = srvyStrtDt;
    }

    public Date getSrvyEndDt() {
        return srvyEndDt;
    }

    public void setSrvyEndDt(Date srvyEndDt) {
        this.srvyEndDt = srvyEndDt;
    }

    public List<SurveyQuestionsDto> getSurveyQuestionsDtos() {
        return surveyQuestionsDtos;
    }

    public void setSurveyQuestionsDtos(List<SurveyQuestionsDto> surveyQuestionsDtos) {
        this.surveyQuestionsDtos = surveyQuestionsDtos;
    }
}
