package com.instructure.bridge.service;

import java.sql.Date;
import java.util.List;

public class Survey {

    private Integer srvyId;
    private String srvyName;
    private Date srvyStrtDt;
    private Date srvyEndDt;

    private List<SurveyQuestions> surveyQuestionses;

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

    public List<SurveyQuestions> getSurveyQuestionses() {
        return surveyQuestionses;
    }

    public void setSurveyQuestionses(List<SurveyQuestions> surveyQuestionses) {
        this.surveyQuestionses = surveyQuestionses;
    }
}
