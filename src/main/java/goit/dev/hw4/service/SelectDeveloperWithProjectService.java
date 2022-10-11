package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.query.*;
import goit.dev.hw4.query.executor.SelectQueryExecutor;

import java.util.List;

public class SelectDeveloperWithProjectService implements SelectService<DeveloperWithProjects> {
    DatabaseManagerConnector connector;

    public SelectDeveloperWithProjectService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public List<DeveloperWithProjects> select(Query<DeveloperWithProjects> query) {
        SelectQueryExecutor<DeveloperWithProjects> executor = new SelectQueryExecutor<>(connector);
        return executor.execute (query);
    }
}
