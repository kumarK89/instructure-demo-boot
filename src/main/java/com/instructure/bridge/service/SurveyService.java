package com.instructure.bridge.service;

import com.instructure.bridge.service.dto.SurveyQuestionsDto;

import java.util.List;

public interface SurveyService {

    List<SurveyQuestionsDto> getSurveyQuestions(Integer srvyId);
}
