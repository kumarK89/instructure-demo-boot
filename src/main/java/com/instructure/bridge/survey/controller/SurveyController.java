package com.instructure.bridge.survey.controller;

import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.service.GetSurveyRequest;
import com.instructure.bridge.survey.service.GetSurveyResponse;
import com.instructure.bridge.survey.service.api.SurveyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
public class SurveyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);

    private final SurveyService surveyService;

    private final RequestFactory requestFactory;

    private final SuccessResponseConverter successResponseConverter;

    public SurveyController(SurveyService surveyService, RequestFactory requestFactory
            , SuccessResponseConverter successResponseConverter) {
        this.surveyService = surveyService;
        this.requestFactory = requestFactory;
        this.successResponseConverter = successResponseConverter;
    }

    /**
     * Making a Rest call to the service to get the Survey questions for a particular user.
     * It sends a HTTP GET Request and produces a application/json response.
     *
     * @param srvyId
     * @return application/json
     */
    @RequestMapping(value = "/getSurveyQustions", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSurveyResponse> getSurveyQuestions
    (@RequestParam(value = "srvyId") final Integer srvyId) {
        LOGGER.info("In /getSurveyQustions GET Request for srvyId - {}", srvyId);
        GetSurveyRequest getSurveyRequest = requestFactory.
                getSurveyRequestForUserId(0, srvyId, null);
        GetSurveyResponse getSurveyResponse = surveyService.getSurveyQuestions(getSurveyRequest);
        return successResponseConverter.convert(getSurveyResponse);
    }

    @RequestMapping(value = "/getSurveyDetails", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSurveyResponse> getUserSurveyDetails(@RequestParam(value = "usrId")
                                                                  final Integer usrId) {
        LOGGER.info("In /getSurveyDetails GET Request for usrId - {}", usrId);
        GetSurveyRequest getSurveyRequest = requestFactory
                .getSurveyRequestForUserId(usrId, 0, null);
        GetSurveyResponse getSurveyResponse = surveyService.getUserSurveyDetails(getSurveyRequest);
        return successResponseConverter.convert(getSurveyResponse);
    }

    @RequestMapping(value = "/submitSurvey/{usrId}/{srvyId}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> submitSurvey(@PathVariable(value = "usrId") final Integer usrId,
                                          @PathVariable(value = "srvyId") final Integer srvyId,
                                          @RequestBody final List<SurveyQuestions>
                                                  surveyQuestionses) {
        LOGGER.info("In /submitSurvey/{usrId}/{srvyId} POST Request for userId - {} srvyId - {}"
                , usrId, srvyId);
        GetSurveyRequest getSurveyRequest = requestFactory
                .getSurveyRequestForUserId(usrId, srvyId, surveyQuestionses);
        surveyService.submitSurvey(getSurveyRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserSurveyQustions", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSurveyResponse> getUserSurveyQustions
            (@RequestParam(value = "srvyId") final Integer srvyId,
             @RequestParam(value = "usrId") final Integer usrId) {
        LOGGER.info("In /getUserSurveyQustions GET Request for userId - {} srvyId - {} "
                , usrId, srvyId);
        GetSurveyRequest getSurveyRequest = requestFactory
                .getSurveyRequestForUserId(usrId, srvyId, null);
        GetSurveyResponse getSurveyResponse = surveyService
                .getUserSurveyQustions(getSurveyRequest);
        return successResponseConverter.convert(getSurveyResponse);
    }
}
