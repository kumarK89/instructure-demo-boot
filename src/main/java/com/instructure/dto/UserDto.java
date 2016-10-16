package com.instructure.dto;

import java.util.List;

public class UserDto {

    private Integer userId;
    private String userName;

    private List<SurveyDto> surveyDtos;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<SurveyDto> getSurveyDtos() {
        return surveyDtos;
    }

    public void setSurveyDtos(List<SurveyDto> surveyDtos) {
        this.surveyDtos = surveyDtos;
    }
}
