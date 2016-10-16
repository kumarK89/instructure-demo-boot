package com.instructure.dao;

import com.instructure.db.tables.records.InstrSrvyQtnOptsRecord;
import com.instructure.db.tables.records.InstrSrvyQtnsRecord;

import org.jooq.DSLContext;

import java.util.List;

import static com.instructure.db.tables.InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS;
import static com.instructure.db.tables.InstrSrvyQtns.INSTR_SRVY_QTNS;

public class SurveyDaoImpl implements SurveyDao {

    private final DSLContext dsl;

    public SurveyDaoImpl(final DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<InstrSrvyQtnsRecord> getSurveyQuestions(Integer srvyId) {
        return dsl.selectFrom(INSTR_SRVY_QTNS)
                .where(INSTR_SRVY_QTNS.SRVY_ID.eq(srvyId)).fetch();
    }

    @Override
    public List<InstrSrvyQtnOptsRecord> getSurveyOptions(Integer srvyQtnId) {
        return dsl.selectFrom(INSTR_SRVY_QTN_OPTS)
                .where(INSTR_SRVY_QTN_OPTS.SRVY_QTN_ID.eq(srvyQtnId)).fetch();
    }
}
