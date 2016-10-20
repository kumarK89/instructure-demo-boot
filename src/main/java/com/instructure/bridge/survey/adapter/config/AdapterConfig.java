package com.instructure.bridge.survey.adapter.config;

import com.instructure.bridge.survey.adapter.SurveyAdapter;
import com.instructure.bridge.survey.adapter.SurveyAdapterImpl;
import com.instructure.bridge.survey.adapter.utils.SurveyAdapterConverter;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    @Bean
    public SurveyAdapterConverter surveyAdapterConverter() {
        return new SurveyAdapterConverter();
    }

    @Bean
    public SurveyAdapter surveyAdapter(final DSLContext dsl,
                                       final SurveyAdapterConverter surveyAdapterConverter) {
        return new SurveyAdapterImpl(dsl, surveyAdapterConverter);
    }
}
