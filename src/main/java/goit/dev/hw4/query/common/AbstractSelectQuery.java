package goit.dev.hw4.query.common;

import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractSelectQuery extends AbstractQuery {

    public AbstractSelectQuery(FilterCondition filterCondition) {
        super(filterCondition);
    }
}