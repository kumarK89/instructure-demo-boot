package com.instructure.dao;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

import jooq.codgen.tables.InstrSrvyQtnOpts;
import jooq.codgen.tables.InstrSrvyQtns;
import jooq.codgen.tables.records.InstrSrvyQtnOptsRecord;
import jooq.codgen.tables.records.InstrSrvyQtnsRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SurveyDaoTests {

    private SurveyDao surveyDao;

    @Before
    public void setUp() {
        MockConnection mockConnection = new MockConnection(new SurveyMockDataProvider());
        DSLContext dslContext = DSL.using(mockConnection, SQLDialect.H2);
        surveyDao = new SurveyDaoImpl(dslContext);
    }

    @Test
    public void test1GetSurveyQuestionsTest() {
        List<InstrSrvyQtnsRecord> srvyQtns = surveyDao.getSurveyQuestions(1);
        Assert.assertEquals(1, srvyQtns.size());
    }

    @Test
    public void test2GetSurveyOptionsTest() {
        List<InstrSrvyQtnOptsRecord> srvyQtnOptn = surveyDao.getSurveyOptions(1);
        Assert.assertEquals(1, srvyQtnOptn.size());
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


