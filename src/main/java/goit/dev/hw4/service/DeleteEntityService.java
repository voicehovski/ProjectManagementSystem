package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.Query;
import goit.dev.hw4.query.executor.DeleteQueryExecutor;

public class DeleteEntityService implements DeleteService {
    DatabaseManagerConnector connector;

    public DeleteEntityService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public void delete(Query query) {
        new DeleteQueryExecutor(connector).execute(query);
    }
}
