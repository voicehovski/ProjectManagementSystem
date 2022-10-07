package goit.dev.hw4.service;

import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.query.condition.FilterCondition;
import goit.dev.hw4.query.executor.SelectQueryExecutor;

import java.util.List;

public abstract class SelectService<E> {
    protected SelectQueryExecutor<E> executor;

    public abstract List<E> select();

    public abstract List<E> select (FilterCondition filterCondition);
}
