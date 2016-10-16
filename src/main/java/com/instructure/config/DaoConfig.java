package com.instructure.config;

import com.instructure.dao.SurveyDao;
import com.instructure.dao.SurveyDaoImpl;
import com.instructure.dao.UserSurveyDao;
import com.instructure.dao.UserSurveyDaoImpl;

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
