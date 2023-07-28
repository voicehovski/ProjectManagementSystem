package goit.dev.hw4.service;

import goit.dev.hw4.query.common.Query;

public interface InsertService {
    <R> long insert (Query<R> query);
}