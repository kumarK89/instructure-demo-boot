package com.instructure.transaction;

import org.jooq.Transaction;
import org.jooq.TransactionContext;
import org.jooq.TransactionProvider;
import org.jooq.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class JooqSpringTransactionProvider implements TransactionProvider {

    private static final Logger JOOQ_LOGGER = LoggerFactory.getLogger(
            JooqSpringTransactionProvider.class);

    private final DataSourceTransactionManager dataSourceTransactionManager;

    public JooqSpringTransactionProvider(
            final DataSourceTransactionManager dataSourceTransactionManager) {
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }

    @Override
    public void begin(TransactionContext transactionContext) throws DataAccessException {
        JOOQ_LOGGER.info("Begin Transaction");
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction
                (new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_NESTED));
        transactionContext.transaction(new JooqSpringTransaction(transactionStatus));
    }

    @Override
    public void commit(TransactionContext transactionContext) throws DataAccessException {
        JOOQ_LOGGER.info("commit transaction");
        dataSourceTransactionManager.commit(
                ((JooqSpringTransaction) transactionContext.transaction()).transactionStatus);
    }

    @Override
    public void rollback(TransactionContext transactionContext) throws DataAccessException {
        JOOQ_LOGGER.info("rollback transaction");
        dataSourceTransactionManager.rollback(
                ((JooqSpringTransaction) transactionContext.transaction()).transactionStatus);
    }
}

class JooqSpringTransaction implements Transaction {
    final TransactionStatus transactionStatus;

    JooqSpringTransaction(final TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
