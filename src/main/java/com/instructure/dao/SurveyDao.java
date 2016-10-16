package com.instructure.dao;


import java.util.List;

import jooq.codgen.tables.records.InstrSrvyQtnOptsRecord;
import jooq.codgen.tables.records.InstrSrvyQtnsRecord;

public interface SurveyDao {

    List<InstrSrvyQtnsRecord> getSurveyQuestions(Integer srvyId);

    List<InstrSrvyQtnOptsRecord> getSurveyOptions(Integer srvyQtnId);
}
