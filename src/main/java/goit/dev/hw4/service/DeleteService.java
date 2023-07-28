package goit.dev.hw4.service;

import goit.dev.hw4.query.common.Query;

public interface DeleteService<R> {
        void delete (Query<R> query);
}
