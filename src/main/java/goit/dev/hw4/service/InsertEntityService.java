package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.common.Query;
import goit.dev.hw4.query.executor.InsertQueryExecutor;

public class InsertEntityService implements InsertService {
    DatabaseManagerConnector connector;

    public InsertEntityService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public long insert(Query query) {
        InsertQueryExecutor executor = new InsertQueryExecutor(connector);
        return executor.execute(query);
    }
}
