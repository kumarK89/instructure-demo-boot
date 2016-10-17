package com.instructure.controller.exception;


import com.instructure.controller.dto.ResponseDto;
import com.instructure.utils.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(RuntimeException.class)
    public ResponseDto exceptionHandler(RuntimeException ex) {
        LOGGER.error(ex.getLocalizedMessage());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Constants.FAILURE);
        responseDto.setErrors("Please contact your administrator");
        return new ResponseDto();
    }
}
