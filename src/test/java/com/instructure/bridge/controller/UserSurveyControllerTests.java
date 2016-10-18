package com.instructure.bridge.controller;

import com.instructure.bridge.service.UserSurveyService;
import com.instructure.bridge.service.dto.SurveyQuestionsDto;
import com.instructure.bridge.service.dto.UserDto;

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
@WebMvcTest(UserSurveyController.class)
public class UserSurveyControllerTests {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserSurveyService userSurveyService;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Test
    public void testGetUserSurveyDetails() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserId(1);
        given(this.userSurveyService.getUserSurveyDetails(Mockito.anyInt())).willReturn(userDto);
        this.mockMvc.perform(get("/user/getSurveyDetails?usrId=1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        Mockito.verify(this.userSurveyService).getUserSurveyDetails(1);
    }

    @Test
    public void testGetUserSurveyQustions() throws Exception {
        List<SurveyQuestionsDto> surveyQuestionsDtos = new ArrayList<>();
        SurveyQuestionsDto surveyQuestionsDto = new SurveyQuestionsDto();
        surveyQuestionsDtos.add(surveyQuestionsDto);
        given(this.userSurveyService.getUserSurveyQustions(Mockito.anyInt(), Mockito.anyInt()))
                .willReturn(surveyQuestionsDtos);

        this.mockMvc.perform(get("/user/getUserSurveyQustions?usrId=1&srvyId=1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        Mockito.verify(this.userSurveyService).getUserSurveyQustions(1, 1);
    }

    @Test
    public void testSubmitSurvey() throws Exception {
        Mockito.doNothing().when(userSurveyService)
                .submitSurvey(Mockito.anyInt(), anyInt(), anyListOf(SurveyQuestionsDto.class));
        List<SurveyQuestionsDto> surveyQuestionsDtos = new ArrayList<>();
        SurveyQuestionsDto surveyQuestionsDto = new SurveyQuestionsDto();
        surveyQuestionsDtos.add(surveyQuestionsDto);
        this.mockMvc.perform(post("/user/submitSurvey/1/1")
                .content(json(surveyQuestionsDtos))
                .contentType(contentType))
                .andExpect(status().isOk());
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
