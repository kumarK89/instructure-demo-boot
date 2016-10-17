package com.instructure.dao.exception;

import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultExecuteListener;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;

public class ExceptionTranslator extends DefaultExecuteListener {
    @Override
    public void exception(ExecuteContext ctx) {
        if (ctx.sqlException() != null) {
            SQLDialect sqlDialect = ctx.dialect();
            SQLExceptionTranslator sqlExceptionTranslator = (sqlDialect != null)
                    ? new SQLErrorCodeSQLExceptionTranslator(sqlDialect.thirdParty().springDbName())
                    : new SQLStateSQLExceptionTranslator();
            ctx.exception(sqlExceptionTranslator.translate("jOOQ", ctx.sql(), ctx.sqlException()));
        }
    }
}
