package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.Query;
import goit.dev.hw4.query.executor.AgreagteQueryExecutor;

public class TotalSalaryService extends AgregateService <Integer> {
    private DatabaseManagerConnector connector;

    public TotalSalaryService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public Integer get(Query<Integer> query) {
        AgreagteQueryExecutor<Integer> executor = new AgreagteQueryExecutor<>(connector);
        return executor.execute(query);
    }
}
