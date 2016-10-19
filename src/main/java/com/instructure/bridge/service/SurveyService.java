package com.instructure.bridge.service;

import java.util.List;

public interface SurveyService {

    List<SurveyQuestions> getSurveyQuestions(Integer srvyId);
}
