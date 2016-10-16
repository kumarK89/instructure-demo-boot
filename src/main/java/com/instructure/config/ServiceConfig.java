package com.instructure.config;

import com.instructure.dao.SurveyDao;
import com.instructure.dao.UserSurveyDao;
import com.instructure.service.SurveyService;
import com.instructure.service.SurveyServiceImpl;
import com.instructure.service.UserSurveyService;
import com.instructure.service.UserSurveyServiceImpl;

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
