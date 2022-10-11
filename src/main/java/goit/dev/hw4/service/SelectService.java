package goit.dev.hw4.service;

import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.query.Query;
import goit.dev.hw4.query.condition.FilterCondition;
import goit.dev.hw4.query.executor.SelectQueryExecutor;

import java.util.List;

public abstract class SelectService<E> {
    protected SelectQueryExecutor<E> executor;  // todo оно тут надо? С одной стороны меньше создавать. С другой - будет висеть в памяти

    public abstract List<E> select (Query<E> query);
}
