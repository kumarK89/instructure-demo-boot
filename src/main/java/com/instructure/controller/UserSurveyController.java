package com.instructure.controller;

import com.instructure.controller.dto.ResponseDto;
import com.instructure.service.dto.SurveyQuestionsDto;
import com.instructure.service.dto.UserDto;
import com.instructure.service.UserSurveyService;
import com.instructure.utils.Constants;
import com.instructure.utils.ReplaceNull;

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
@CrossOrigin(origins = "http://localhost:3000")
public class UserSurveyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSurveyController.class);

    private final UserSurveyService userSurveyService;

    public UserSurveyController(final UserSurveyService userSurveyService) {
        this.userSurveyService = userSurveyService;
    }

    @RequestMapping(value = "/getSurveyDetails", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto getUserSurveyDetails(@RequestParam(value = "usrId")
                                            final Integer usrId) {
        LOGGER.info("In /getSurveyDetails GET Request");
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Constants.SUCCESS);
        responseDto.setData(userSurveyService.getUserSurveyDetails(usrId));
        return responseDto;
    }

    @RequestMapping(value = "/submitSurvey/{usrId}/{srvyId}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto submitSurvey(@PathVariable(value = "usrId") final Integer usrId,
                                    @PathVariable(value = "srvyId") final Integer srvyId,
                                    @RequestBody final List<SurveyQuestionsDto>
                                            surveyQuestionsDtos) {
        LOGGER.info("In /submitSurvey/{usrId}/{srvyId} POST Request");
        userSurveyService.submitSurvey(usrId, srvyId, surveyQuestionsDtos);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Constants.SUCCESS);
        return responseDto;
    }

    @RequestMapping(value = "/getUserSurveyQustions", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto getUserSurveyQustions
            (@RequestParam(value = "srvyId") final Integer srvyId,
             @RequestParam(value = "usrId") final Integer usrId) {
        LOGGER.info("In /getUserSurveyQustions GET Request");
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Constants.SUCCESS);
        responseDto.setData(ReplaceNull.withEmptyList(userSurveyService
                .getUserSurveyQustions(usrId, srvyId)));
        return responseDto;
    }
}
