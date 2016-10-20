package com.instructure.bridge.survey.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponseConverter {

    public ResponseEntity<Object> convert(String errMsg, HttpStatus httpStatus) {
        return new ResponseEntity<>(errMsg, httpStatus);
    }
}
