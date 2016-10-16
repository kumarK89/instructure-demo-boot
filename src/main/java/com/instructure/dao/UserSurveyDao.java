package com.instructure.dao;

import com.instructure.db.tables.records.InstrUsrSrvyMpngRecord;
import com.instructure.db.tables.records.InstrUsrSrvyQtnOptRecord;

import org.jooq.Record5;
import org.jooq.Record6;

import java.sql.Date;
import java.util.List;

public interface UserSurveyDao {

    List<Record6<Integer, String, Integer, String, Date, Date>>
    getAssignedSurveysForUser(Integer userId);

    void submitSurvey(List<InstrUsrSrvyQtnOptRecord> usrSrvyQtnOptRecords);

    InstrUsrSrvyMpngRecord getUserSrvyMpngRcrd(Integer usrId, Integer srvyId);

    List<Record5<String, Integer, Integer, String, Boolean>>
    getUserSurveyQustions(Integer usrId, Integer srvyId);

}
