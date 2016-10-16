package com.instructure.controller;

import com.instructure.dto.SurveyQuestionsDto;
import com.instructure.service.SurveyService;
import com.instructure.utils.ReplaceNull;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "survey")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping(value = "/getSurveyQustions", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SurveyQuestionsDto> getSurveyQuestions
            (@RequestParam(value = "srvyId") final Integer srvyId) {
        return ReplaceNull.withEmptyList(surveyService.getSurveyQuestions(srvyId));
    }
}
