package goit.dev.hw4.service;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.query.*;
import goit.dev.hw4.query.condition.FilterCondition;
import goit.dev.hw4.query.executor.SelectQueryExecutor;

import java.util.List;

public class SelectDeveloperWithProjectService extends SelectService<DeveloperWithProjects> {
    public SelectDeveloperWithProjectService(SelectQueryExecutor<DeveloperWithProjects> executor) {
        this.executor = executor;
    }

    @Override
    public List<DeveloperWithProjects> select() {
        Query<DeveloperWithProjects> query = new SelectDeveloperWithProjectsQuery();
        return executor.execute (query);
    }

    @Override
    public List<DeveloperWithProjects> select(FilterCondition filterCondition) {
        Query<DeveloperWithProjects> query = new FilterByProjectNameDeveloperWithProjectsQuery(filterCondition);
        return executor.execute (query);
    }
}
