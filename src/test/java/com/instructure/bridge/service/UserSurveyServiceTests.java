package com.instructure.bridge.service;

import com.instructure.bridge.dao.UserSurveyDao;
import com.instructure.bridge.service.dto.SurveyQuestionOptionsDto;
import com.instructure.bridge.service.dto.SurveyQuestionsDto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jooq.codgen.tables.records.InstrUsrSrvyMpngRecord;
import jooq.codgen.tables.records.InstrUsrSrvyQtnOptRecord;

import static org.mockito.Matchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class UserSurveyServiceTests {

    @Mock
    UserSurveyDao userSurveyDao;

    @Before
    public void intializeMocks() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test the Get Surveys which are available for the particular User.
     */
    @Test
    public void testGetUserSurveyDetails() {
        Mockito.stub(userSurveyDao.getAssignedSurveysForUser(anyInt()))
                .toReturn(Collections.emptyList());
        UserSurveyService userSurveyService = new UserSurveyServiceImpl(userSurveyDao);
        userSurveyService.getUserSurveyDetails(anyInt());
        Mockito.verify(userSurveyDao).getAssignedSurveysForUser(anyInt());
    }

    /**
     * Test whether the answer submitted are properly going to DAO layer to submit.
     */
    @Test
    public void testSubmitSurvey() {

        UserSurveyService userSurveyService = new UserSurveyServiceImpl(userSurveyDao);
        List<SurveyQuestionsDto> surveyQuestionsDtos = new ArrayList<>();
        List<SurveyQuestionOptionsDto> surveyQuestionOptionsDtos = new ArrayList<>();
        SurveyQuestionOptionsDto surveyQuestionOptionsDto = new SurveyQuestionOptionsDto();
        surveyQuestionOptionsDto.setOptionSelected(true);
        surveyQuestionOptionsDto.setOptText("Test");
        surveyQuestionOptionsDto.setSrvyQtnOptId(1);
        surveyQuestionOptionsDtos.add(surveyQuestionOptionsDto);
        SurveyQuestionsDto surveyQuestionsDto = new SurveyQuestionsDto();
        surveyQuestionsDto.setQtnTxt("Test");
        surveyQuestionsDto.setSrvyQtnId(1);
        surveyQuestionsDto.setSurveyQuestionOptionsDtos(surveyQuestionOptionsDtos);
        surveyQuestionsDtos.add(surveyQuestionsDto);
        Mockito.when(userSurveyDao.getUserSrvyMpngRcrd(anyInt(), anyInt()))
                .thenReturn(createInstrUsrSrvyMpngRecord());
        Mockito.doNothing().when(userSurveyDao).submitSurvey
                (Mockito.anyListOf(InstrUsrSrvyQtnOptRecord.class));
        userSurveyService.submitSurvey(anyInt(), anyInt(), surveyQuestionsDtos);
        Mockito.verify(userSurveyDao).getUserSrvyMpngRcrd(anyInt(), anyInt());
        Mockito.verify(userSurveyDao).submitSurvey
                (Mockito.anyListOf(InstrUsrSrvyQtnOptRecord.class));

    }

    private InstrUsrSrvyMpngRecord createInstrUsrSrvyMpngRecord() {
        InstrUsrSrvyMpngRecord instrUsrSrvyMpngRecord = new InstrUsrSrvyMpngRecord();
        instrUsrSrvyMpngRecord.setUsrSrvyMpngId(1);
        instrUsrSrvyMpngRecord.setSrvyId(1);
        instrUsrSrvyMpngRecord.setUsrId(1);
        return instrUsrSrvyMpngRecord;
    }

    /**
     * Test whether the GetUserSurveyQustions method is returning the
     * surveyQuestionsDtos list or not.
     */
    @Test
    public void testGetUserSurveyQustions() {
        UserSurveyService userSurveyService = new UserSurveyServiceImpl(userSurveyDao);
        Mockito.stub(userSurveyDao.getUserSurveyQustions(anyInt(), anyInt()))
                .toReturn(Collections.EMPTY_LIST);
        userSurveyService.getUserSurveyQustions(anyInt(), anyInt());
        Mockito.verify(userSurveyDao).getUserSurveyQustions(anyInt(), anyInt());
    }
}