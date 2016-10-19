package com.instructure.bridge.controller;

import com.instructure.bridge.service.SurveyQuestions;
import com.instructure.bridge.service.SurveyService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SurveyController.class)
public class SurveyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyService surveyService;

    @Test
    public void testGetSurveyQuestions() throws Exception {
        List<SurveyQuestions> surveyQuestionsList = new ArrayList<>();
        SurveyQuestions surveyQuestions = new SurveyQuestions();
        surveyQuestionsList.add(surveyQuestions);
        given(this.surveyService.getSurveyQuestions(Mockito.anyInt()))
                .willReturn(surveyQuestionsList);
        this.mockMvc.perform(get("/survey/getSurveyQustions?srvyId=1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        Mockito.verify(this.surveyService).getSurveyQuestions(1);

    }
}
