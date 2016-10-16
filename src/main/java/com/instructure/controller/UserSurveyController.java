package com.instructure.controller;

import com.instructure.dto.SurveyQuestionsDto;
import com.instructure.dto.UserDto;
import com.instructure.service.UserSurveyService;
import com.instructure.utils.ReplaceNull;

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

    private final UserSurveyService userSurveyService;

    public UserSurveyController(final UserSurveyService userSurveyService) {
        this.userSurveyService = userSurveyService;
    }

    @RequestMapping(value = "/getSurveyDetails", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUserSurveyDetails(@RequestParam(value = "usrId")
                                        final Integer usrId) {
        return userSurveyService.getUserSurveyDetails(usrId);
    }

    @RequestMapping(value = "/submitSurvey/{usrId}/{srvyId}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void submitSurvey(@PathVariable(value = "usrId") final Integer usrId,
                             @PathVariable(value = "srvyId") final Integer srvyId,
                             @RequestBody final List<SurveyQuestionsDto> surveyQuestionsDtos) {
        userSurveyService.submitSurvey(usrId, srvyId, surveyQuestionsDtos);
    }

    @RequestMapping(value = "/getUserSurveyQustions", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SurveyQuestionsDto> getUserSurveyQustions
            (@RequestParam(value = "srvyId") final Integer srvyId,
             @RequestParam(value = "usrId") final Integer usrId) {
        return ReplaceNull.withEmptyList(userSurveyService.getUserSurveyQustions(usrId, srvyId));
    }
}
