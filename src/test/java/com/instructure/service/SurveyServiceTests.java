package com.instructure.service;

import com.instructure.dao.SurveyDao;
import com.instructure.service.dto.SurveyQuestionsDto;

import jooq.codgen.tables.records.InstrSrvyQtnOptsRecord;
import jooq.codgen.tables.records.InstrSrvyQtnsRecord;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Matchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class SurveyServiceTests {


    @Mock
    SurveyDao surveyDao;

    @Before
    public void intializeMocks() {
        MockitoAnnotations.initMocks(this);
    }


    private InstrSrvyQtnsRecord createSurveyWithSrvyId(int srvyid, int srvyQusId) {
        java.util.Date date = new java.util.Date();
        InstrSrvyQtnsRecord instrSrvyQtnsRecord = new InstrSrvyQtnsRecord();
        instrSrvyQtnsRecord.setSrvyId(srvyid);
        instrSrvyQtnsRecord.setSrvyQtnId(srvyQusId);
        instrSrvyQtnsRecord.setQtnTxt("Question" + srvyid);
        instrSrvyQtnsRecord.setCrtdTime(new Date(date.getTime()));
        instrSrvyQtnsRecord.setCrtdUsr("Skota");
        instrSrvyQtnsRecord.setLstUpdtdTime(new Date(date.getTime()));
        instrSrvyQtnsRecord.setLstUpdtdUsr("Skota");

        return instrSrvyQtnsRecord;
    }

    private InstrSrvyQtnOptsRecord createSurveyOptionsSrvyId(int srvyid, int srvyQusId) {
        java.util.Date date = new java.util.Date();
        InstrSrvyQtnOptsRecord instrSrvyQtnsRecord = new InstrSrvyQtnOptsRecord();
        instrSrvyQtnsRecord.setSrvyQtnOptId(srvyQusId);
        instrSrvyQtnsRecord.setSrvyQtnId(srvyid);
        instrSrvyQtnsRecord.setOptText("Answer" + srvyid);
        instrSrvyQtnsRecord.setCrtdTime(new Date(date.getTime()));
        instrSrvyQtnsRecord.setCrtdUsr("Skota");
        instrSrvyQtnsRecord.setLstUpdtdTime(new Date(date.getTime()));
        instrSrvyQtnsRecord.setLstUpdtdUsr("Skota");

        return instrSrvyQtnsRecord;
    }

    /**
     * Test whether the GetSurveyQuestions is returning proper list.
     */
    @Test
    public void testGetSurveyQuestions() {

        List<InstrSrvyQtnsRecord> srvyQtnsRecords = new ArrayList<>();
        srvyQtnsRecords.add(createSurveyWithSrvyId(1, 1));
        srvyQtnsRecords.add(createSurveyWithSrvyId(1, 2));

        List<InstrSrvyQtnOptsRecord> srvyQtnsOptnRecords = new ArrayList<>();
        srvyQtnsOptnRecords.add(createSurveyOptionsSrvyId(1, 1));
        srvyQtnsOptnRecords.add(createSurveyOptionsSrvyId(1, 2));

        Mockito.stub(surveyDao.getSurveyQuestions(anyInt())).toReturn(srvyQtnsRecords);
        Mockito.stub(surveyDao.getSurveyOptions(anyInt())).toReturn(srvyQtnsOptnRecords);

        SurveyService service = new SurveyServiceImpl(surveyDao);
        List<SurveyQuestionsDto> surveyQuestionsDtos = service.getSurveyQuestions(1);
        Mockito.verify(surveyDao).getSurveyQuestions(anyInt());
        Assert.assertEquals(2, surveyQuestionsDtos.size());
    }


}
