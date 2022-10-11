package goit.dev.hw4.service;

import goit.dev.hw4.query.Query;

public interface AgregateService<E> {
    E get (Query<E> query);
}
