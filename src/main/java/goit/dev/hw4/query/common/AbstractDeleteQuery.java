package goit.dev.hw4.query.common;

import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public abstract class AbstractDeleteQuery implements Query {
    private FilterCondition filterCondition;

    public AbstractDeleteQuery(FilterCondition filterCondition) {
        this.filterCondition = filterCondition;
    }

    @Override
    public PreparedStatement createStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getQuery());
        filterCondition.setConditionTo(statement);
        return statement;
    }

    @Override
    public List createEntity(ResultSet rs) throws SQLException {
        return Collections.emptyList();
    }

    public abstract String getQuery ();
}