package goit.dev.hw4.query.common;

import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public abstract class AbstractInsertQuery implements Query {
    private FilterCondition filterCondition;

    public AbstractInsertQuery(FilterCondition filterCondition) {
        this.filterCondition = filterCondition;
    }

    @Override
    public PreparedStatement createStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getQuery(), Statement.RETURN_GENERATED_KEYS);
        filterCondition.setConditionTo(statement);
        return statement;
    }

    @Override
    public List createEntity(ResultSet rs) throws SQLException {
        return Collections.emptyList();
    }

    public abstract String getQuery ();
}