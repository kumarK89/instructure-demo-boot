package com.instructure.bridge.survey.service.api;

import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.domain.User;
import com.instructure.bridge.survey.service.GetSurveyRequest;
import com.instructure.bridge.survey.service.GetSurveyResponse;

import java.util.List;

public interface SurveyService {

    GetSurveyResponse getSurveyQuestions(GetSurveyRequest getSurveyRequest);

    GetSurveyResponse getUserSurveyDetails(GetSurveyRequest getSurveyRequest);

    void submitSurvey(GetSurveyRequest getSurveyRequest);

    GetSurveyResponse getUserSurveyQustions(GetSurveyRequest getSurveyRequest);
}
