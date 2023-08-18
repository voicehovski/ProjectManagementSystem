package goit.dev.hw4.query.common;

import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public abstract class AbstractDeleteQuery extends AbstractQuery {
    public AbstractDeleteQuery(FilterCondition filterCondition) {
        super(filterCondition);
    }
}