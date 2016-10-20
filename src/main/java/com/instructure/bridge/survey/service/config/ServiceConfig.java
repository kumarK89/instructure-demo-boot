package com.instructure.bridge.survey.service.config;

import com.instructure.bridge.survey.adapter.SurveyAdapter;
import com.instructure.bridge.survey.service.api.SurveyService;
import com.instructure.bridge.survey.service.impl.SurveyServiceImpl;
import com.instructure.bridge.survey.service.utils.SurveyServiceConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public SurveyServiceConverter surveyServiceConverter() {
        return new SurveyServiceConverter();
    }

    @Bean
    public SurveyService surveyService(final SurveyAdapter surveyAdapter,
                                       final SurveyServiceConverter surveyServiceConverter) {
        return new SurveyServiceImpl(surveyAdapter, surveyServiceConverter);
    }
}
