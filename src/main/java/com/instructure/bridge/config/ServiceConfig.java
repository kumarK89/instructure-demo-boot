package com.instructure.bridge.config;

import com.instructure.bridge.service.SurveyService;
import com.instructure.bridge.service.SurveyServiceImpl;
import com.instructure.bridge.dao.SurveyDao;
import com.instructure.bridge.dao.UserSurveyDao;
import com.instructure.bridge.service.UserSurveyService;
import com.instructure.bridge.service.UserSurveyServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public UserSurveyService userSurveyService(final UserSurveyDao userSurveyDao) {
        return new UserSurveyServiceImpl(userSurveyDao);
    }

    @Bean
    public SurveyService surveyService(final SurveyDao surveyDao) {
        return new SurveyServiceImpl(surveyDao);
    }
}
