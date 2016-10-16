package com.instructure.dao;

import com.instructure.db.tables.records.InstrSrvyQtnOptsRecord;
import com.instructure.db.tables.records.InstrSrvyQtnsRecord;

import java.util.List;

public interface SurveyDao {

    List<InstrSrvyQtnsRecord> getSurveyQuestions(Integer srvyId);

    List<InstrSrvyQtnOptsRecord> getSurveyOptions(Integer srvyQtnId);
}
