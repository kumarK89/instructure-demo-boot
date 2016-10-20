package com.instructure.bridge.survey.service.impl;

import com.instructure.bridge.survey.adapter.SurveyAdapter;
import com.instructure.bridge.survey.service.api.SurveyService;
import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.domain.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class SurveyServiceTests {


    @Mock
    SurveyAdapter surveyAdapter;

    @Mock
    SurveyDomain surveyDomain;

    SurveyService surveyService = null;

    @Before
    public void intializeMocks() {
        MockitoAnnotations.initMocks(this);
        surveyService = new SurveyServiceImpl(surveyAdapter, surveyDomain);
    }

    /**
     * Test whether the GetSurveyQuestions is returning proper list.
     */
    @Test
    public void testGetSurveyQuestions() {
        List<SurveyQuestions> surveyQuestionses = new ArrayList<>();
        SurveyQuestions surveyQuestions = new SurveyQuestions();
        surveyQuestions.setSrvyQtnId(1);
        surveyQuestionses.add(surveyQuestions);
        Mockito.stub(surveyAdapter.getSurveyQuestions(anyInt())).toReturn(surveyQuestionses);
        List<SurveyQuestions> surveyQuestionsesRes = surveyService.getSurveyQuestions(1);
        Mockito.verify(surveyAdapter).getSurveyQuestions(anyInt());
        Assert.assertNotNull(surveyQuestionses);
    }

    @Test
    public void testGetUserSurveyDetails() {
        User user = new User();
        Mockito.stub(surveyAdapter.getAssignedSurveysForUser(anyInt()))
                .toReturn(user);
        User userRes = surveyService.getUserSurveyDetails(1);
        Assert.assertNotNull(userRes);
    }

    @Test
    public void testSubmitSurvey() {
        Mockito.doReturn(1).when(surveyAdapter)
                .getUserSrvyMpngRcrd(Mockito.any(), Mockito.anyInt());
        Mockito.doNothing().when(surveyAdapter).submitSurvey
                (Mockito.anyListOf(SurveyQuestions.class), Mockito.anyInt());
        surveyService.submitSurvey(1, 1, new ArrayList<>());
        Mockito.verify(surveyAdapter).getUserSrvyMpngRcrd(1, 1);
    }

    @Test
    public void testUserSurveyQuestions() {
        Mockito.doReturn(new ArrayList<SurveyQuestions>()).when(surveyAdapter).
                getUserSurveyQustions(Mockito.anyInt(), Mockito.anyInt());
        List<SurveyQuestions> surveyQuestionses = surveyService.getUserSurveyQustions(1, 1);
        Assert.assertNotNull(surveyQuestionses);
    }
}
