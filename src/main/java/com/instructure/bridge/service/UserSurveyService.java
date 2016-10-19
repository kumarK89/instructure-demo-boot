package com.instructure.bridge.service;

import java.util.List;

public interface UserSurveyService {

    User getUserSurveyDetails(int userId);

    void submitSurvey(Integer usrId, Integer srvyId, List<SurveyQuestions> surveyQuestionses);

    List<SurveyQuestions> getUserSurveyQustions(Integer usrId, Integer srvyId);
}
