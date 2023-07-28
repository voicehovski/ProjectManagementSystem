package goit.dev.hw4.service;

import goit.dev.hw4.query.common.AbstractInsertQuery;

public interface InsertService {
    long insert (AbstractInsertQuery query);
}