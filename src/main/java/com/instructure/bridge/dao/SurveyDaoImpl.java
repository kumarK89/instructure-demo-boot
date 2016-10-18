package com.instructure.bridge.dao;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import jooq.codgen.tables.records.InstrSrvyQtnOptsRecord;
import jooq.codgen.tables.records.InstrSrvyQtnsRecord;

import static jooq.codgen.tables.InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS;
import static jooq.codgen.tables.InstrSrvyQtns.INSTR_SRVY_QTNS;

public class SurveyDaoImpl implements SurveyDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyDaoImpl.class);

    private final DSLContext dsl;

    public SurveyDaoImpl(final DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<InstrSrvyQtnsRecord> getSurveyQuestions(Integer srvyId) {
        LOGGER.debug("In getSurveyQuestions for srvyId - " + srvyId);
        return dsl.selectFrom(INSTR_SRVY_QTNS)
                .where(INSTR_SRVY_QTNS.SRVY_ID.eq(srvyId)).fetch();
    }

    @Override
    public List<InstrSrvyQtnOptsRecord> getSurveyOptions(Integer srvyQtnId) {
        LOGGER.debug("In getSurveyOptions for srvyQtnId - " + srvyQtnId);
        return dsl.selectFrom(INSTR_SRVY_QTN_OPTS)
                .where(INSTR_SRVY_QTN_OPTS.SRVY_QTN_ID.eq(srvyQtnId)).fetch();
    }
}
