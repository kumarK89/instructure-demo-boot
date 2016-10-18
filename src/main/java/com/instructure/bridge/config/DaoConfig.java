package com.instructure.bridge.config;

import com.instructure.bridge.dao.SurveyDaoImpl;
import com.instructure.bridge.dao.UserSurveyDao;
import com.instructure.bridge.dao.UserSurveyDaoImpl;
import com.instructure.bridge.dao.SurveyDao;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public SurveyDao surveyDao(final DSLContext dsl) {
        return new SurveyDaoImpl(dsl);
    }

    @Bean
    public UserSurveyDao userDao(final DSLContext dsl) {
        return new UserSurveyDaoImpl(dsl);
    }
}
