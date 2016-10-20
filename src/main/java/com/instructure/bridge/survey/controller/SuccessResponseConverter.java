package com.instructure.bridge.survey.controller;

import com.instructure.bridge.common.Converter;
import com.instructure.bridge.survey.service.GetSurveyResponse;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SuccessResponseConverter {

    public ResponseEntity<GetSurveyResponse> convert(GetSurveyResponse getSurveyResponse) {
        return new ResponseEntity<GetSurveyResponse>(getSurveyResponse, HttpStatus.OK);
    }
}
