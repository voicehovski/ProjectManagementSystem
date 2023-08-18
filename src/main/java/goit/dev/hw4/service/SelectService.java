package goit.dev.hw4.service;

import goit.dev.hw4.model.builder.EntityBuilder;
import goit.dev.hw4.query.common.AbstractSelectQuery;
import goit.dev.hw4.query.common.Query;

import java.util.List;

// todo Нужны ли *Service интерфейсы?
public interface SelectService {
    <E> List<E> select (AbstractSelectQuery query, EntityBuilder<E> builder);
}

