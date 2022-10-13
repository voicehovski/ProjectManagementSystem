package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.common.Query;
import goit.dev.hw4.query.executor.UpdateQueryExecutor;

public class UpdateEntityService implements UpdateService {
    DatabaseManagerConnector connector;

    public UpdateEntityService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public void update (Query query) {
        new UpdateQueryExecutor(connector).execute(query);
    }
}
