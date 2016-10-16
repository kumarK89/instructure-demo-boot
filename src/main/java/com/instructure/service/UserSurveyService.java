package com.instructure.service;

import com.instructure.dto.SurveyQuestionsDto;
import com.instructure.dto.UserDto;

import java.util.List;

public interface UserSurveyService {

    UserDto getUserSurveyDetails(int userId);

    void submitSurvey(Integer usrId, Integer srvyId, List<SurveyQuestionsDto> surveyQuestionsDtos);

    List<SurveyQuestionsDto> getUserSurveyQustions(Integer usrId, Integer srvyId);
}
