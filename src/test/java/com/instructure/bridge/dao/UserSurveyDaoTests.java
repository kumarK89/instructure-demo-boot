package com.instructure.bridge.dao;


import jooq.codgen.tables.InstrSrvyQtnOpts;
import jooq.codgen.tables.InstrSrvyQtns;
import jooq.codgen.tables.InstrUsrSrvyMpng;
import jooq.codgen.tables.InstrUsrSrvyQtnOpt;
import jooq.codgen.tables.records.*;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.tools.jdbc.MockConnection;
import org.jooq.tools.jdbc.MockDataProvider;
import org.jooq.tools.jdbc.MockExecuteContext;
import org.jooq.tools.jdbc.MockResult;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserSurveyDaoTests {
    UserSurveyDao userSurveyDao;
    DSLContext dslContext;

    @Before
    public void setUp() {
        MockConnection mockConnection = new MockConnection(new UserSurveyMockDataProvider());
        dslContext = DSL.using(mockConnection, SQLDialect.POSTGRES);
        userSurveyDao = new UserSurveyDaoImpl(dslContext);
    }

    @Test
    public void test1GetAssignedSurveysForUserTest() {
        List<Record6<Integer, String, Integer, String, Date, Date>> surveysAssignedForUser = userSurveyDao.getAssignedSurveysForUser(1);
        Assert.assertEquals(1, surveysAssignedForUser.size());
    }

    @Test
    public void test2SubmitSurveyWithUserSurveyQustnOptionsTest() {
        List<InstrUsrSrvyQtnOptRecord> usrSrvyQtnOptRecords = new ArrayList<>();
        InstrUsrSrvyQtnOptRecord instrUsrSrvyQtnOptRecord = new InstrUsrSrvyQtnOptRecord();
        usrSrvyQtnOptRecords.add(instrUsrSrvyQtnOptRecord);
        userSurveyDao.submitSurvey(usrSrvyQtnOptRecords);
    }



    @Test
    public void test3GetUserSrvyMpngRcrd() {
        InstrUsrSrvyMpngRecord usrSrvyMpngRecord = userSurveyDao.getUserSrvyMpngRcrd(1, 1);
        Assert.assertEquals(7, usrSrvyMpngRecord.size());
    }

    @Test
    public void test4GetUserSurveyQustions() {
        List<Record5<String, Integer, Integer, String, Boolean>> userSurveyQuestns = userSurveyDao.getUserSurveyQustions(1, 1);
        Assert.assertEquals(1, userSurveyQuestns.size());
    }

}

class UserSurveyMockDataProvider implements MockDataProvider {
    private String QtnTxt = "Dumb User Survey";

    // private boolean isSelectForSurveyQuestions = Boolean.TRUE;
    private boolean isSelectForAssignedSurveysForUser = Boolean.TRUE;
    private boolean isSelectForUserSrvyMpngRcrd = Boolean.TRUE;
    private boolean isSelectForUserSurveyQustions = Boolean.TRUE;
    private boolean isInsertForSurveyWithUserSurveyQustnOptions = Boolean.TRUE;

    //private boolean isSelectForAssignedSurveysForUser = Boolean.TRUE;
    @Override
    public MockResult[] execute(MockExecuteContext ctx) throws SQLException {
        DSLContext create = DSL.using(SQLDialect.POSTGRES);
        MockResult[] mock = new MockResult[1];
        String sql = ctx.sql();
        if (sql.toUpperCase().startsWith("SELECT")) {
            if (isSelectForAssignedSurveysForUser) {
                Result<InstrUsrSrvyMpngRecord> result = create.newResult(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG);
                result.add(create.newRecord(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG));
                //result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.SRVY_ID, 1);
                result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.USR_ID, 1);
                result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.USR_SRVY_MPNG_ID, 1);
                mock[0] = new MockResult(1, result);
                isSelectForAssignedSurveysForUser = Boolean.FALSE;
            } else if (isSelectForUserSrvyMpngRcrd) {
                Result<InstrUsrSrvyMpngRecord> result = create.newResult(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG);
                result.add(create.newRecord(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG));
                result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.SRVY_ID, 1);
                result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.USR_ID, 1);
                result.get(0).setValue(InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG.USR_SRVY_MPNG_ID, 1);
                mock[0] = new MockResult(1, result);
                isSelectForAssignedSurveysForUser = Boolean.FALSE;
            } else if (isSelectForUserSurveyQustions) {
                Result<InstrUsrSrvyQtnOptRecord> result = create.newResult(InstrUsrSrvyQtnOpt.INSTR_USR_SRVY_QTN_OPT);
                result.add(create.newRecord(InstrUsrSrvyQtnOpt.INSTR_USR_SRVY_QTN_OPT));
                result.get(0).setValue(InstrUsrSrvyQtnOpt.INSTR_USR_SRVY_QTN_OPT.USR_SRVY_MPNG_ID, 1);
                mock[0] = new MockResult(1, result);
                isSelectForUserSrvyMpngRcrd = Boolean.FALSE;
            }
        } else if (sql.toUpperCase().startsWith("INSERT")) {
            mock[0] = new MockResult(1, create.newResult(InstrUsrSrvyQtnOpt.INSTR_USR_SRVY_QTN_OPT));
        }
        return mock;
    }
}
