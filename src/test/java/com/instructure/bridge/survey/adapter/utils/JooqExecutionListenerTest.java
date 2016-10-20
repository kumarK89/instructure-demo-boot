package com.instructure.bridge.survey.adapter.utils;

import com.instructure.bridge.survey.adapter.utils.JooqExecuteListener;

import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

/**
 * Created by skota on 10/19/2016.
 */
@RunWith(SpringRunner.class)
public class JooqExecutionListenerTest {

    JooqExecuteListener jooqExecuteListener = new JooqExecuteListener();

    @Mock
    ExecuteContext executeContext;

    @Test
    public void testStart() {
        Object object = new Object();
        Mockito.doReturn(object).when(executeContext).data(Mockito.anyObject(), Mockito.anyObject());

        jooqExecuteListener.start(executeContext);
        Mockito.verify(executeContext).data(Mockito.anyObject(), Mockito.anyObject());
    }

    @Test
    public void testEnd() {
        Mockito.doReturn((Long) 1L).
                when(executeContext).data(Mockito.anyObject());
        jooqExecuteListener.end(executeContext);
        Mockito.verify(executeContext).data(Mockito.anyObject());

    }

    @Test
    public void testExceptionforNullSqlException() {
        Mockito.doReturn(null).when(executeContext).sqlException();
        jooqExecuteListener.exception(executeContext);
        Mockito.verify(executeContext).sqlException();
    }

    @Test
    public void testExceptionforSqlException() {
        Mockito.doReturn(new SQLException()).when(executeContext).sqlException();
        Mockito.doReturn(SQLDialect.POSTGRES).when(executeContext).dialect();
        Mockito.doReturn("").when(executeContext).sql();
        Mockito.doNothing().when(executeContext).exception(Mockito.any(DataAccessException.class));
        jooqExecuteListener.exception(executeContext);
        Mockito.verify(executeContext).dialect();
    }
}
