package goit.dev.hw4.query;

import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public abstract class AbstractInsertQuery implements Query {
    protected FilterCondition filterCondition;

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