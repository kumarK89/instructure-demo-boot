package com.instructure.bridge.controller.exception;


import com.instructure.bridge.controller.dto.ResponseDto;
import com.instructure.bridge.service.exception.InvalidSurveyException;
import com.instructure.bridge.utils.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(basePackages = {"com.instructure.bridge.controller"})
@RestController
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(RuntimeException.class)
    public ResponseDto exceptionHandler(RuntimeException ex) {
        LOGGER.error("RuntimeException Raised - ", ex);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Constants.FAILURE.toString());
        responseDto.setErrors("Some Error occured While processing the request");
        return new ResponseDto();
    }

    @ExceptionHandler(InvalidSurveyException.class)
    public ResponseDto exceptionHandler(InvalidSurveyException ex) {
        LOGGER.error("Invalid Survey Exception Raised ", ex);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Constants.FAILURE.toString());
        responseDto.setErrors(ex.getLocalizedMessage());
        return new ResponseDto();
    }
}