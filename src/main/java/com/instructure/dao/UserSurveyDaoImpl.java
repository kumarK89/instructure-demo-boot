package com.instructure.dao;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Record6;
import org.jooq.impl.DSL;

import java.sql.Date;
import java.util.List;

import jooq.codgen.tables.InstrSrvyDtls;
import jooq.codgen.tables.InstrSrvyQtnOpts;
import jooq.codgen.tables.InstrSrvyQtns;
import jooq.codgen.tables.InstrUsrDtls;
import jooq.codgen.tables.InstrUsrSrvyMpng;
import jooq.codgen.tables.InstrUsrSrvyQtnOpt;
import jooq.codgen.tables.records.InstrUsrSrvyMpngRecord;
import jooq.codgen.tables.records.InstrUsrSrvyQtnOptRecord;

import static jooq.codgen.Sequences.INSTR_USR_SRVY_QTN_OPT_SEQ;
import static jooq.codgen.tables.InstrSrvyDtls.INSTR_SRVY_DTLS;
import static jooq.codgen.tables.InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS;
import static jooq.codgen.tables.InstrSrvyQtns.INSTR_SRVY_QTNS;
import static jooq.codgen.tables.InstrUsrDtls.INSTR_USR_DTLS;
import static jooq.codgen.tables.InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG;
import static jooq.codgen.tables.InstrUsrSrvyQtnOpt.INSTR_USR_SRVY_QTN_OPT;

public class UserSurveyDaoImpl implements UserSurveyDao {

    private final DSLContext dsl;

    public UserSurveyDaoImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<Record6<Integer, String, Integer, String, Date, Date>>
    getAssignedSurveysForUser(Integer userId) {
        InstrUsrDtls usr = INSTR_USR_DTLS.as("usr");
        InstrSrvyDtls srvy = INSTR_SRVY_DTLS.as("srvy");
        InstrUsrSrvyMpng mpng = INSTR_USR_SRVY_MPNG.as("mpng");
        return dsl.select(usr.USER_ID, usr.USER_NAME,
                srvy.SRVY_ID, srvy.SRVY_NAME, srvy.SRVY_STRT_DT, srvy.SRVY_END_DT)
                .from(usr, srvy, mpng)
                .where(mpng.USR_ID.equal(usr.USER_ID))
                .and(mpng.SRVY_ID.equal(srvy.SRVY_ID))
                .and(usr.USER_ID.equal(DSL.inline(userId))).fetch();
    }

    @Override
    public void submitSurvey(List<InstrUsrSrvyQtnOptRecord> usrSrvyQtnOptRecords) {
        dsl.transaction(t ->
                usrSrvyQtnOptRecords.forEach(usrSrvyQtnOptRecord -> {
                    Record1<Long> seqVal = dsl.select(INSTR_USR_SRVY_QTN_OPT_SEQ
                            .nextval()).fetchOne();
                    dsl.insertInto(INSTR_USR_SRVY_QTN_OPT,
                            INSTR_USR_SRVY_QTN_OPT.USR_SRVY_QTN_OPT_ID,
                            INSTR_USR_SRVY_QTN_OPT.SRVY_QTN_ID,
                            INSTR_USR_SRVY_QTN_OPT.SRVY_QTN_OPT_ID)
                            .values(seqVal.value1().intValue(), usrSrvyQtnOptRecord.getSrvyQtnId()
                                    , usrSrvyQtnOptRecord.getUsrSrvyQtnOptId()).execute();
                })
        );
    }

    @Override
    public InstrUsrSrvyMpngRecord getUserSrvyMpngRcrd(Integer usrId, Integer srvyId) {
        return dsl.selectFrom(INSTR_USR_SRVY_MPNG).
                where(INSTR_USR_SRVY_MPNG.USR_ID.eq(usrId)).
                and(INSTR_USR_SRVY_MPNG.SRVY_ID.eq(srvyId)).fetchOne();
    }

    @Override
    public List<Record5<String, Integer, Integer, String, Boolean>>
    getUserSurveyQustions(Integer usrId, Integer srvyId) {
        InstrUsrDtls usr = INSTR_USR_DTLS.as("usr");
        InstrSrvyDtls srvy = INSTR_SRVY_DTLS.as("srvy");
        InstrSrvyQtns srvyqtns = INSTR_SRVY_QTNS.as("srvyqtns");
        InstrSrvyQtnOpts srvyqtnopts = INSTR_SRVY_QTN_OPTS.as("srvyqtnopts");
        InstrUsrSrvyMpng usrsrvympng = INSTR_USR_SRVY_MPNG.as("usrsrvympng");
        InstrUsrSrvyQtnOpt usrsrvyqtnopt = INSTR_USR_SRVY_QTN_OPT.as("usrsrvyqtnopt");
        Field<Boolean> is_option_selected = DSL.decode()
                .when(dsl.select(usrsrvyqtnopt.USR_SRVY_QTN_OPT_ID)
                        .from(usrsrvyqtnopt)
                        .where(usrsrvyqtnopt.SRVY_QTN_ID.equal(srvyqtns.SRVY_QTN_ID)
                                .and(usrsrvyqtnopt.SRVY_QTN_OPT_ID
                                        .equal(srvyqtnopts.SRVY_QTN_OPT_ID))
                                .and(usrsrvyqtnopt.USR_SRVY_MPNG_ID
                                        .equal(usrsrvympng.USR_SRVY_MPNG_ID)))
                        .asField().isNull(), DSL.inline(Boolean.FALSE))
                .otherwise(DSL.inline(Boolean.TRUE)).as("is_option_selected");
        return dsl.select
                (srvyqtns.QTN_TXT, srvyqtns.SRVY_QTN_ID, srvyqtnopts.SRVY_QTN_OPT_ID,
                        srvyqtnopts.OPT_TEXT, is_option_selected)
                .from(usr, srvy, srvyqtns, srvyqtnopts, usrsrvympng)
                .where(usr.USER_ID.equal(DSL.inline(usrId))
                        .and(srvy.SRVY_ID.equal(DSL.inline(srvyId)))
                        .and(usrsrvympng.USR_ID.equal(usr.USER_ID))
                        .and(usrsrvympng.SRVY_ID.equal(srvy.SRVY_ID))
                        .and(srvyqtns.SRVY_ID.equal(srvy.SRVY_ID))
                        .and(srvyqtnopts.SRVY_QTN_ID.equal(srvyqtns.SRVY_QTN_ID))).fetch();
    }
}
