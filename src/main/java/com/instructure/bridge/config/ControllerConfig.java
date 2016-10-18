package com.instructure.bridge.config;

import com.instructure.bridge.controller.UserSurveyController;
import com.instructure.bridge.service.SurveyService;
import com.instructure.bridge.service.UserSurveyService;
import com.instructure.bridge.controller.SurveyController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public UserSurveyController userSurveyController(final UserSurveyService userSurveyService) {
        return new UserSurveyController(userSurveyService);
    }

    @Bean
    public SurveyController surveyController(final SurveyService surveyService) {
        return new SurveyController(surveyService);
    }
}
