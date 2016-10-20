package com.instructure.bridge.survey.controller.config;

import com.instructure.bridge.survey.controller.ErrorResponseConverter;
import com.instructure.bridge.survey.controller.ExceptionControllerAdvice;
import com.instructure.bridge.survey.controller.RequestFactory;
import com.instructure.bridge.survey.controller.SuccessResponseConverter;
import com.instructure.bridge.survey.controller.SurveyController;
import com.instructure.bridge.survey.service.api.SurveyService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public SuccessResponseConverter successResponseConverter() {
        return new SuccessResponseConverter();
    }

    @Bean
    public ErrorResponseConverter errorResponseConverter() {
        return new ErrorResponseConverter();
    }

    @Bean
    public RequestFactory requestFactory() {
        return new RequestFactory();
    }

    @Bean
    public SurveyController surveyController(final SurveyService surveyService,
                                             final RequestFactory requestFactory,
                                             final SuccessResponseConverter
                                                     successResponseConverter) {
        return new SurveyController(surveyService, requestFactory, successResponseConverter);
    }

    @Bean
    public ExceptionControllerAdvice exceptionControllerAdvice(final ErrorResponseConverter
                                                                       errorResponseConverter) {
        return new ExceptionControllerAdvice(errorResponseConverter);
    }
}
