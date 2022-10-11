package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.query.Query;
import goit.dev.hw4.query.SelectDeveloperQuery;
import goit.dev.hw4.query.condition.FilterCondition;
import goit.dev.hw4.query.executor.SelectQueryExecutor;

import java.util.List;

public class SelectDeveloperService extends SelectService<Developer> {
    DatabaseManagerConnector connector;

    public SelectDeveloperService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public List<Developer> select (Query<Developer> query) {
        //FilterCondition filterCondition = statement -> statement.setString(1,skillTrend);
        SelectQueryExecutor<Developer> executor = new SelectQueryExecutor<>(connector);
        return executor.execute (query);
    }
}
