package goit.dev.hw4.query.common;

import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractQuery implements Query {
    protected FilterCondition filterCondition;

    public AbstractQuery(FilterCondition filterCondition) {
        this.filterCondition = filterCondition;
    }

    @Override
    public PreparedStatement createStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getQuery());
        filterCondition.setConditionTo(statement);
        return statement;
    }
}
