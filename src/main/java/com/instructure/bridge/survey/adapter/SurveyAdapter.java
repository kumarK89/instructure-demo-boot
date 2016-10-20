package com.instructure.bridge.survey.adapter;

import java.util.List;

import com.instructure.bridge.survey.domain.SurveyQuestionOptions;
import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.domain.User;

public interface SurveyAdapter {

    List<SurveyQuestions> getSurveyQuestions(Integer srvyId);

    List<SurveyQuestionOptions> getSurveyOptions(Integer srvyQtnId);

    User getAssignedSurveysForUser(Integer userId);

    void submitSurvey(List<SurveyQuestions> surveyQuestionses, Integer usrSrvyMpngId);

    Integer getUserSrvyMpngRcrd(Integer usrId, Integer srvyId);

    List<SurveyQuestions> getUserSurveyQustions(Integer usrId, Integer srvyId);
}
