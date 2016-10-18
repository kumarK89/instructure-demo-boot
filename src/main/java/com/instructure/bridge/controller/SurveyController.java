package com.instructure.bridge.controller;

import com.instructure.bridge.controller.dto.ResponseDto;
import com.instructure.bridge.service.SurveyService;
import com.instructure.bridge.service.dto.SurveyQuestionsDto;
import com.instructure.bridge.utils.Constants;
import com.instructure.bridge.utils.ReplaceNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class contains all the REST calls related to Survey
 */
@RestController
@RequestMapping(value = "survey")
@CrossOrigin(origins = "http://localhost:3000")
public class SurveyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);
    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    /**
     * Making a Rest call to the service to get the Survey questions for a particular user.
     * It sends a HTTP GET Request and produces a application/json response.
     *
     * @param srvyId
     * @return application/json
     *
     */
    @RequestMapping(value = "/getSurveyQustions", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto getSurveyQuestions
    (@RequestParam(value = "srvyId") final Integer srvyId) {
        LOGGER.info("In /getSurveyQustions GET Request");
        List<SurveyQuestionsDto> surveyQuestionsDtos = ReplaceNull.withEmptyList(surveyService
                .getSurveyQuestions(srvyId));
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Constants.SUCCESS);
        responseDto.setData(surveyQuestionsDtos);
        return responseDto;
    }
}
