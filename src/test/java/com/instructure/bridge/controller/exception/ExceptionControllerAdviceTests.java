package com.instructure.bridge.controller.exception;


import com.instructure.bridge.controller.SurveyController;
import com.instructure.bridge.service.SurveyService;
import com.instructure.bridge.service.exception.InvalidSurveyException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SurveyController.class)
public class ExceptionControllerAdviceTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyService surveyService;

    @Test
    public void testHandleException() throws Exception {

        given(this.surveyService.getSurveyQuestions(Mockito.anyInt()))
                .willThrow(new RuntimeException());
        mockMvc.perform(get("/survey/getSurveyQustions?srvyId=1"))
                .andExpect(new ResultMatcher() {
                    @Override
                    public void match(MvcResult result) throws Exception {
                        result.getResponse().getContentAsString().contains("global_error_test");
                    }
                })
                .andExpect(status().isOk());
    }

    @Test
    public void testHandleExceptionForInvalidSurveyException() throws Exception {

        given(this.surveyService.getSurveyQuestions(Mockito.anyInt()))
                .willThrow(new InvalidSurveyException("Invalid Survey"));
        mockMvc.perform(get("/survey/getSurveyQustions?srvyId=1"))
                .andExpect(new ResultMatcher() {
                    @Override
                    public void match(MvcResult result) throws Exception {
                        result.getResponse().getContentAsString().contains("global_error_test");
                    }
                })
                .andExpect(status().isOk());
    }
}
