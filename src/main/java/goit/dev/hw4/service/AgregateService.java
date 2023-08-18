package goit.dev.hw4.service;

import goit.dev.hw4.model.builder.EntityBuilder;
import goit.dev.hw4.query.common.AbstractSelectQuery;

public interface AgregateService {
    <E> E get (AbstractSelectQuery query, EntityBuilder <E> builder);
}
