package com.instructure.bridge.survey.adapter;


import com.instructure.bridge.survey.adapter.entity.tables.InstrSrvyDtls;
import com.instructure.bridge.survey.adapter.entity.tables.InstrSrvyQtnOpts;
import com.instructure.bridge.survey.adapter.entity.tables.InstrSrvyQtns;
import com.instructure.bridge.survey.adapter.entity.tables.InstrUsrDtls;
import com.instructure.bridge.survey.adapter.entity.tables.InstrUsrSrvyMpng;
import com.instructure.bridge.survey.adapter.entity.tables.InstrUsrSrvyQtnOpt;
import com.instructure.bridge.survey.adapter.entity.tables.records.InstrSrvyQtnOptsRecord;
import com.instructure.bridge.survey.adapter.entity.tables.records.InstrSrvyQtnsRecord;
import com.instructure.bridge.survey.adapter.entity.tables.records.InstrUsrSrvyMpngRecord;
import com.instructure.bridge.survey.adapter.entity.tables.records.InstrUsrSrvyQtnOptRecord;
import com.instructure.bridge.survey.adapter.utils.SurveyAdapterConverter;
import com.instructure.bridge.survey.domain.SurveyQuestionOptions;
import com.instructure.bridge.survey.domain.SurveyQuestions;
import com.instructure.bridge.survey.domain.User;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Record6;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.List;

import static com.instructure.bridge.survey.adapter.entity.Sequences.INSTR_USR_SRVY_QTN_OPT_SEQ;
import static com.instructure.bridge.survey.adapter.entity.tables.InstrSrvyDtls.INSTR_SRVY_DTLS;
import static com.instructure.bridge.survey.adapter.entity.tables.InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS;
import static com.instructure.bridge.survey.adapter.entity.tables.InstrSrvyQtns.INSTR_SRVY_QTNS;
import static com.instructure.bridge.survey.adapter.entity.tables.InstrUsrDtls.INSTR_USR_DTLS;
import static com.instructure.bridge.survey.adapter.entity.tables.InstrUsrSrvyMpng.INSTR_USR_SRVY_MPNG;
import static com.instructure.bridge.survey.adapter.entity.tables.InstrUsrSrvyQtnOpt.INSTR_USR_SRVY_QTN_OPT;

public class SurveyAdapterImpl implements SurveyAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyAdapterImpl.class);

    private final DSLContext dsl;

    private final SurveyAdapterConverter surveyAdapterConverter;

    public SurveyAdapterImpl(final DSLContext dsl, SurveyAdapterConverter surveyAdapterConverter) {
        this.dsl = dsl;
        this.surveyAdapterConverter = surveyAdapterConverter;
    }

    @Override
    public List<SurveyQuestions> getSurveyQuestions(Integer srvyId) {
        List<InstrSrvyQtnsRecord> instrSrvyQtnsRecords = null;
        LOGGER.debug("In getSurveyQuestions for srvyId - {} ", srvyId);
        instrSrvyQtnsRecords = dsl.selectFrom(INSTR_SRVY_QTNS)
                .where(INSTR_SRVY_QTNS.SRVY_ID.eq(srvyId)).fetch();
        return surveyAdapterConverter.convertQtnRcrds(instrSrvyQtnsRecords);
    }

    @Override
    public List<SurveyQuestionOptions> getSurveyOptions(Integer srvyQtnId) {
        LOGGER.debug("In getSurveyOptions for srvyQtnId - {}", srvyQtnId);
        List<InstrSrvyQtnOptsRecord> srvyQtnOptsRecords = dsl.selectFrom(INSTR_SRVY_QTN_OPTS)
                .where(INSTR_SRVY_QTN_OPTS.SRVY_QTN_ID.eq(srvyQtnId)).fetch();
        return surveyAdapterConverter.convertOptnRcrds(srvyQtnOptsRecords);
    }

    @Override
    public User getAssignedSurveysForUser(Integer userId) {
        LOGGER.debug("In getAssignedSurveysForUser for userId - {} ", userId);
        InstrUsrDtls usr = INSTR_USR_DTLS.as("usr");
        InstrSrvyDtls srvy = INSTR_SRVY_DTLS.as("srvy");
        InstrUsrSrvyMpng mpng = INSTR_USR_SRVY_MPNG.as("mpng");
        List<Record6<Integer, String, Integer, String, Date, Date>> record6List =
                dsl.select(usr.USER_ID, usr.USER_NAME,
                        srvy.SRVY_ID, srvy.SRVY_NAME, srvy.SRVY_STRT_DT, srvy.SRVY_END_DT)
                        .from(usr, srvy, mpng)
                        .where(mpng.USR_ID.equal(usr.USER_ID))
                        .and(mpng.SRVY_ID.equal(srvy.SRVY_ID))
                        .and(usr.USER_ID.equal(DSL.inline(userId))).fetch();
        return surveyAdapterConverter.covertRecord6Rcrds(record6List);
    }

    @Override
    public void submitSurvey(List<SurveyQuestions> surveyQuestionses, Integer usrSrvyMpngId) {
        LOGGER.debug("In submitSurvey");
        List<InstrUsrSrvyQtnOptRecord> usrSrvyQtnOptRecords = surveyAdapterConverter.
                convertSurveyQuestions(surveyQuestionses, usrSrvyMpngId);
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
    public Integer getUserSrvyMpngRcrd(Integer usrId, Integer srvyId) {
        LOGGER.debug("In getUserSrvyMpngRcrd for usrId - {} srvyId - {}", usrId, srvyId);
        InstrUsrSrvyMpngRecord srvyMpngRecord = dsl.selectFrom(INSTR_USR_SRVY_MPNG).
                where(INSTR_USR_SRVY_MPNG.USR_ID.eq(usrId)).
                and(INSTR_USR_SRVY_MPNG.SRVY_ID.eq(srvyId)).fetchOne();
        if (srvyMpngRecord == null) {
            return null;
        }
        return srvyMpngRecord.getUsrSrvyMpngId();
    }

    @Override
    public List<SurveyQuestions> getUserSurveyQustions(Integer usrId, Integer srvyId) {
        LOGGER.debug("In getUserSurveyQustions for usrId - {} srvyId - {}", usrId, srvyId);
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
        List<Record5<String, Integer, Integer, String, Boolean>> surveyQtnLst = dsl.select
                (srvyqtns.QTN_TXT, srvyqtns.SRVY_QTN_ID, srvyqtnopts.SRVY_QTN_OPT_ID,
                        srvyqtnopts.OPT_TEXT, is_option_selected)
                .from(usr, srvy, srvyqtns, srvyqtnopts, usrsrvympng)
                .where(usr.USER_ID.equal(DSL.inline(usrId))
                        .and(srvy.SRVY_ID.equal(DSL.inline(srvyId)))
                        .and(usrsrvympng.USR_ID.equal(usr.USER_ID))
                        .and(usrsrvympng.SRVY_ID.equal(srvy.SRVY_ID))
                        .and(srvyqtns.SRVY_ID.equal(srvy.SRVY_ID))
                        .and(srvyqtnopts.SRVY_QTN_ID.equal(srvyqtns.SRVY_QTN_ID))).fetch();
        return surveyAdapterConverter.covertRecord5Rcrds(surveyQtnLst);
    }
}
