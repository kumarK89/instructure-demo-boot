package com.instructure.bridge.controller.exception;


import com.instructure.bridge.controller.dto.ResponseDto;
import com.instructure.bridge.utils.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(basePackages = {"com.instructure.controller"})
@RestController
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(RuntimeException.class)
    public ResponseDto exceptionHandler(RuntimeException ex) {
        LOGGER.error(ex.getLocalizedMessage());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Constants.FAILURE);
        responseDto.setErrors("Some Error occured While processing the request");
        return new ResponseDto();
    }
}
