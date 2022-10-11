package goit.dev.hw4.service;

import goit.dev.hw4.query.Query;

import java.util.List;

public interface SelectService<E> {
    List<E> select (Query<E> query);
}


interface UpdateService<R> {
    void update (Query<R> query);
}

interface DeleteService<R> {
    void delete (Query<R> query);
}