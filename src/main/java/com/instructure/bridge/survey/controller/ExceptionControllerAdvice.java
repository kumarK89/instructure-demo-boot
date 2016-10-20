package com.instructure.bridge.survey.controller;


import com.instructure.bridge.survey.service.exception.InvalidSurveyException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(basePackages = {"com.instructure.bridge.controller"})
@RestController
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    private final ErrorResponseConverter errorResponseConverter;

    public ExceptionControllerAdvice(ErrorResponseConverter errorResponseConverter) {
        this.errorResponseConverter = errorResponseConverter;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> exceptionHandler(RuntimeException ex) {
        LOGGER.error("RuntimeException Raised - ", ex);
        String errMSg = "Some Error occured While processing the request";
        return errorResponseConverter.convert(errMSg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidSurveyException.class)
    public ResponseEntity<Object> exceptionHandler(InvalidSurveyException ex) {
        LOGGER.error("Invalid Survey Exception Raised ", ex);
        String errMSg = "Invalid Survey";
        return errorResponseConverter.convert(errMSg, HttpStatus.BAD_REQUEST);
    }
}
