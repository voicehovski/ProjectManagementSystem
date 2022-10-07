package goit.dev.hw4.service;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.query.SelectDeveloperQuery;
import goit.dev.hw4.query.condition.FilterCondition;
import goit.dev.hw4.query.executor.SelectQueryExecutor;

import java.util.List;

public class SelectDeveloperService extends SelectService<Developer> {
    public SelectDeveloperService(SelectQueryExecutor<Developer> executor) {
        this.executor = executor;
    }

    public List<Developer> select (FilterCondition filterCondition) {
        //FilterCondition filterCondition = statement -> statement.setString(1,skillTrend);
        SelectDeveloperQuery query = new SelectDeveloperQuery();
        return executor.execute (query);
    }

    @Override
    public List<Developer> select() {
        SelectDeveloperQuery query = new SelectDeveloperQuery();
        return executor.execute (query);
    }
}
