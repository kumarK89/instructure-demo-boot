package com.instructure.service;

import com.instructure.dto.SurveyQuestionsDto;

import java.util.List;

public interface SurveyService {

    List<SurveyQuestionsDto> getSurveyQuestions(Integer srvyId);
}
