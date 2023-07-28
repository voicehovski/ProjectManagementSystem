package goit.dev.hw4.service;

import goit.dev.hw4.query.common.Query;

public interface UpdateService <R> {
    void update (Query<R> query);
}
