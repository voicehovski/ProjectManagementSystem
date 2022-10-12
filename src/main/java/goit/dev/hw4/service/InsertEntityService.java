package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.Query;
import goit.dev.hw4.query.executor.InsertQueryExecutor;

import java.util.List;

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
