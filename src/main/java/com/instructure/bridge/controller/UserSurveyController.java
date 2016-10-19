package com.instructure.bridge.controller;

import com.instructure.bridge.service.SurveyQuestions;
import com.instructure.bridge.utils.Constants;
import com.instructure.bridge.service.UserSurveyService;
import com.instructure.bridge.utils.ReplaceNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserSurveyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSurveyController.class);

    private final UserSurveyService userSurveyService;

    public UserSurveyController(final UserSurveyService userSurveyService) {
        this.userSurveyService = userSurveyService;
    }

    @RequestMapping(value = "/getSurveyDetails", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUserSurveyDetails(@RequestParam(value = "usrId")
                                         final Integer usrId) {
        LOGGER.info("In /getSurveyDetails GET Request for usrId - {}", usrId);
        Response response = new Response();
        response.setStatus(Constants.SUCCESS.toString());
        response.setData(userSurveyService.getUserSurveyDetails(usrId));
        return response;
    }

    @RequestMapping(value = "/submitSurvey/{usrId}/{srvyId}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response submitSurvey(@PathVariable(value = "usrId") final Integer usrId,
                                 @PathVariable(value = "srvyId") final Integer srvyId,
                                 @RequestBody final List<SurveyQuestions>
                                         surveyQuestionses) {
        LOGGER.info("In /submitSurvey/{usrId}/{srvyId} POST Request for userId - {} srvyId - {}"
                , usrId, srvyId);
        userSurveyService.submitSurvey(usrId, srvyId, surveyQuestionses);
        Response response = new Response();
        response.setStatus(Constants.SUCCESS.toString());
        return response;
    }

    @RequestMapping(value = "/getUserSurveyQustions", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUserSurveyQustions
            (@RequestParam(value = "srvyId") final Integer srvyId,
             @RequestParam(value = "usrId") final Integer usrId) {
        LOGGER.info("In /getUserSurveyQustions GET Request for userId - {} srvyId - {} "
                , usrId, srvyId);
        Response response = new Response();
        response.setStatus(Constants.SUCCESS.toString());
        response.setData(ReplaceNull.withEmptyList(userSurveyService
                .getUserSurveyQustions(usrId, srvyId)));
        return response;
    }
}
