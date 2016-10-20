package com.instructure.bridge.controller;

import com.instructure.bridge.survey.controller.SurveyController;
import com.instructure.bridge.survey.service.api.SurveyService;
import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.domain.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SurveyController.class)
public class SurveyControllerTests {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyService surveyService;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Test
    public void testGetUserSurveyDetails() throws Exception {
        User user = new User();
        user.setUserId(1);
        given(this.surveyService.getUserSurveyDetails(Mockito.anyInt())).willReturn(user);
        this.mockMvc.perform(get("/survey/getSurveyDetails?usrId=1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        Mockito.verify(this.surveyService).getUserSurveyDetails(1);
    }

    @Test
    public void testGetUserSurveyQustions() throws Exception {
        List<SurveyQuestions> surveyQuestionses = new ArrayList<>();
        SurveyQuestions surveyQuestions = new SurveyQuestions();
        surveyQuestionses.add(surveyQuestions);
        given(this.surveyService.getUserSurveyQustions(Mockito.anyInt(), Mockito.anyInt()))
                .willReturn(surveyQuestionses);

        this.mockMvc.perform(get("/survey/getUserSurveyQustions?usrId=1&srvyId=1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        Mockito.verify(this.surveyService).getUserSurveyQustions(1, 1);
    }

    @Test
    public void testSubmitSurvey() throws Exception {
        Mockito.doNothing().when(surveyService)
                .submitSurvey(Mockito.anyInt(), anyInt(), anyListOf(SurveyQuestions.class));
        List<SurveyQuestions> surveyQuestionses = new ArrayList<>();
        SurveyQuestions surveyQuestions = new SurveyQuestions();
        surveyQuestionses.add(surveyQuestions);
        this.mockMvc.perform(post("/survey/submitSurvey/1/1")
                .content(json(surveyQuestionses))
                .contentType(contentType))
                .andExpect(status().isOk());
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

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
