package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.query.common.Query;
import goit.dev.hw4.query.executor.SelectQueryExecutor;

import java.util.List;

public class SelectEntityService<E> implements SelectService<E> {
    DatabaseManagerConnector connector;

    public SelectEntityService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public List<E> select (Query<E> query) {
        SelectQueryExecutor<E> executor = new SelectQueryExecutor<>(connector);
        return executor.execute (query);
    }
}
