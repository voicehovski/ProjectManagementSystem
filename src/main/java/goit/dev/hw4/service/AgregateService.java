package goit.dev.hw4.service;

import goit.dev.hw4.query.common.Query;

public interface AgregateService<E> {
    E get (Query<E> query);
}
