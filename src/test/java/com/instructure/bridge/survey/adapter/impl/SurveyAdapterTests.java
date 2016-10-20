package com.instructure.bridge.survey.adapter.impl;

import com.instructure.bridge.survey.adapter.SurveyAdapter;
import com.instructure.bridge.survey.adapter.SurveyAdapterImpl;
import com.instructure.bridge.survey.adapter.entity.tables.InstrSrvyQtnOpts;
import com.instructure.bridge.survey.adapter.entity.tables.InstrSrvyQtns;
import com.instructure.bridge.survey.adapter.entity.tables.InstrUsrSrvyMpng;
import com.instructure.bridge.survey.adapter.entity.tables.InstrUsrSrvyQtnOpt;
import com.instructure.bridge.survey.adapter.entity.tables.records.InstrSrvyQtnOptsRecord;
import com.instructure.bridge.survey.adapter.entity.tables.records.InstrSrvyQtnsRecord;
import com.instructure.bridge.survey.adapter.entity.tables.records.InstrUsrSrvyMpngRecord;
import com.instructure.bridge.survey.adapter.entity.tables.records.InstrUsrSrvyQtnOptRecord;
import com.instructure.bridge.survey.domain.SurveyQuestionOptions;
import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.domain.User;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.tools.jdbc.MockConnection;
import org.jooq.tools.jdbc.MockDataProvider;
import org.jooq.tools.jdbc.MockExecuteContext;
import org.jooq.tools.jdbc.MockResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SurveyAdapterTests {

    private SurveyAdapter surveyAdapter;

    private SurveyAdapter userSurveyAdapter;

    @Before
    public void setUp() {
        MockConnection mockConnection = new MockConnection(new SurveyMockDataProvider());
        DSLContext dslContext = DSL.using(mockConnection, SQLDialect.POSTGRES);
        surveyAdapter = new SurveyAdapterImpl(dslContext);

        MockConnection mockConnection1 = new MockConnection(new UserSurveyMockDataProvider());
        DSLContext dslContext1 = DSL.using(mockConnection1, SQLDialect.POSTGRES);
        userSurveyAdapter = new SurveyAdapterImpl(dslContext1);
    }

    @Test
    public void test1GetSurveyQuestionsTest() {
        List<SurveyQuestions> srvyQtns = surveyAdapter.getSurveyQuestions(1);
        Assert.assertEquals(1, srvyQtns.size());
    }

    @Test
    public void test1GetSurveyQuestionsTestForNull() {
        List<SurveyQuestions> srvyQtns = surveyAdapter.getSurveyQuestions(null);
        Assert.assertEquals(1, srvyQtns.size());
    }

    @Test
    public void test2GetSurveyOptionsTest() {
        List<SurveyQuestionOptions> srvyQtnOptn = surveyAdapter.getSurveyOptions(1);
        Assert.assertEquals(1, srvyQtnOptn.size());
    }

    @Test
    public void test1GetAssignedSurveysForUserTest() {
        User user = userSurveyAdapter.getAssignedSurveysForUser(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void test1GetAssignedSurveysForUserForNull() {
        User user = userSurveyAdapter.getAssignedSurveysForUser(null);
        Assert.assertNotNull(user);
    }


    @Test
    public void test2SubmitSurveyWithUserSurveyQustnOptionsTest() {
        List<SurveyQuestions> surveyQuestionses = new ArrayList<>();
        userSurveyAdapter.submitSurvey(surveyQuestionses, 1);
    }


    @Test
    public void test3GetUserSrvyMpngRcrd() {
        Integer usrSrvyMpngId = userSurveyAdapter.getUserSrvyMpngRcrd(1, 1);
        Assert.assertNotNull(usrSrvyMpngId);
    }

    @Test
    @Ignore
    public void test4GetUserSurveyQustions() {
        List<SurveyQuestions> surveyQuestionses = userSurveyAdapter.getUserSurveyQustions(1, 1);
        Assert.assertEquals(1, surveyQuestionses.size());
    }

    @Test
    @Ignore
    public void test4GetUserSurveyQustionsForNull() {
        List<SurveyQuestions> surveyQuestionses = userSurveyAdapter
                .getUserSurveyQustions(null, null);
        Assert.assertEquals(1, surveyQuestionses.size());
    }
}

class SurveyMockDataProvider implements MockDataProvider {

    private boolean isSelectForSurveyQuestions = Boolean.TRUE;

    @Override
    public MockResult[] execute(MockExecuteContext ctx) throws SQLException {
        DSLContext create = DSL.using(SQLDialect.POSTGRES);
        MockResult[] mock = new MockResult[1];
        String sql = ctx.sql();
        if (sql.toUpperCase().startsWith("SELECT")) {
            if (isSelectForSurveyQuestions) {
                Result<InstrSrvyQtnsRecord> result = create.newResult(InstrSrvyQtns.INSTR_SRVY_QTNS);
                result.add(create.newRecord(InstrSrvyQtns.INSTR_SRVY_QTNS));
                result.get(0).setValue(InstrSrvyQtns.INSTR_SRVY_QTNS.SRVY_QTN_ID, 1);
                result.get(0).setValue(InstrSrvyQtns.INSTR_SRVY_QTNS.SRVY_ID, 1);
                result.get(0).setValue(InstrSrvyQtns.INSTR_SRVY_QTNS.QTN_TXT, "Employee Feedback Survey");
                mock[0] = new MockResult(1, result);
                isSelectForSurveyQuestions = Boolean.FALSE;
            } else {
                Result<InstrSrvyQtnOptsRecord> result = create.newResult(InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS);
                result.add(create.newRecord(InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS));
                result.get(0).setValue(InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS.SRVY_QTN_ID, 1);
                result.get(0).setValue(InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS.SRVY_QTN_OPT_ID, 1);
                result.get(0).setValue(InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS.OPT_TEXT, "Dumb Option");
                mock[0] = new MockResult(1, result);
            }
        }
        return mock;
    }
}

class UserSurveyMockDataProvider implements MockDataProvider {
    private String QtnTxt = "Dumb User Survey";

    private boolean isSelectForAssignedSurveysForUser = Boolean.TRUE;
    private boolean isSelectForUserSrvyMpngRcrd = Boolean.TRUE;
    private boolean isSelectForUserSurveyQustions = Boolean.TRUE;
    private boolean isInsertForSurveyWithUserSurveyQustnOptions = Boolean.TRUE;

    @Override
    public MockResult[] execute(MockExecuteContext ctx) throws SQLException {
        DSLContext create = DSL.using(SQLDialect.POSTGRES);
        MockResult[] mock = new MockResult[1];
        String sql = ctx.sql();
        if (sql.toUpperCase().startsWith("SELECT")) {
            if (isSelectForAssignedSurveysForUser) {
                Result<InstrUsrSrvyMpngRecord> result = create
                        .newResult(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG);
                result.add(create.newRecord(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG));
                //result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.SRVY_ID, 1);
                result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.USR_ID, 1);
                result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.USR_SRVY_MPNG_ID, 1);
                mock[0] = new MockResult(1, result);
                isSelectForAssignedSurveysForUser = Boolean.FALSE;
            } else if (isSelectForUserSrvyMpngRcrd) {
                Result<InstrUsrSrvyMpngRecord> result = create.newResult
                        (InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG);
                result.add(create.newRecord(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG));
                result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.SRVY_ID, 1);
                result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.USR_ID, 1);
                result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.USR_SRVY_MPNG_ID, 1);
                mock[0] = new MockResult(1, result);
                isSelectForAssignedSurveysForUser = Boolean.FALSE;
            } else if (isSelectForUserSurveyQustions) {
                Result<InstrUsrSrvyQtnOptRecord> result = create.newResult
                        (InstrUsrSrvyQtnOpt.INSTR_USR_SRVY_QTN_OPT);
                result.add(create.newRecord(InstrUsrSrvyQtnOpt.INSTR_USR_SRVY_QTN_OPT));
                result.get(0).setValue(InstrUsrSrvyQtnOpt
                        .INSTR_USR_SRVY_QTN_OPT.USR_SRVY_MPNG_ID, 1);
                mock[0] = new MockResult(1, result);
                isSelectForUserSrvyMpngRcrd = Boolean.FALSE;
            }
        } else if (sql.toUpperCase().startsWith("INSERT")) {
            mock[0] = new MockResult(1, create.newResult
                    (InstrUsrSrvyQtnOpt.INSTR_USR_SRVY_QTN_OPT));
        }
        return mock;
    }
}



