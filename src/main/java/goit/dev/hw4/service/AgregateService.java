package goit.dev.hw4.service;

import goit.dev.hw4.query.Query;
import goit.dev.hw4.query.executor.AgreagteQueryExecutor;

public class AgregateService <E> {

    protected AgreagteQueryExecutor<E> executor;

    public E  get (Query<E> query) {
        return executor.execute (query);
    }
}
