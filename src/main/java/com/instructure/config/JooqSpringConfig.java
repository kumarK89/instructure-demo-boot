package com.instructure.config;

import com.instructure.dao.exception.ExceptionTranslator;
import com.instructure.transaction.JooqSpringTransactionProvider;

import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.ExecuteListenerProvider;
import org.jooq.SQLDialect;
import org.jooq.TransactionProvider;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class JooqSpringConfig {

    @Bean
    public DataSourceTransactionManager transactionManager(final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public DSLContext dsl(final org.jooq.Configuration config) {
        return new DefaultDSLContext(config);
    }

    @Bean
    public ConnectionProvider connectionProvider(final DataSource dataSource) {
        return new DataSourceConnectionProvider(
                new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    public TransactionProvider transactionProvider(
            final DataSourceTransactionManager transactionManager) {
        return new JooqSpringTransactionProvider(transactionManager);
    }

    @Bean
    public ExceptionTranslator exceptionTranslator() {
        return new ExceptionTranslator();
    }

    @Bean
    public ExecuteListenerProvider executeListenerProvider(
            final ExceptionTranslator exceptionTranslator) {
        return new DefaultExecuteListenerProvider(exceptionTranslator);

    }

    @Bean
    public org.jooq.Configuration jooqConfig(final ConnectionProvider connectionProvider,
                                             final TransactionProvider transactionProvider,
                                             final ExecuteListenerProvider
                                                     executeListenerProvider) {
        return new DefaultConfiguration()
                .derive(connectionProvider)
                .derive(transactionProvider)
                .derive(executeListenerProvider)
                .derive(SQLDialect.POSTGRES);
    }

}
