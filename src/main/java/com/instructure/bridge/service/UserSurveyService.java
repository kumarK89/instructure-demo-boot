package com.instructure.bridge.service;

import com.instructure.bridge.service.dto.UserDto;
import com.instructure.bridge.service.dto.SurveyQuestionsDto;

import java.util.List;

public interface UserSurveyService {

    UserDto getUserSurveyDetails(int userId);

    void submitSurvey(Integer usrId, Integer srvyId, List<SurveyQuestionsDto> surveyQuestionsDtos);

    List<SurveyQuestionsDto> getUserSurveyQustions(Integer usrId, Integer srvyId);
}
