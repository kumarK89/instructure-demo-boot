package com.instructure.config;

import com.instructure.controller.SurveyController;
import com.instructure.controller.UserSurveyController;
import com.instructure.service.SurveyService;
import com.instructure.service.UserSurveyService;

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
