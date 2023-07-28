package goit.dev.hw4.query.common;

import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public abstract class AbstractInsertQuery extends AbstractQuery<Object> {

    public AbstractInsertQuery(FilterCondition filterCondition) {
        super(filterCondition);
    }

    @Override
    public PreparedStatement createStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getQuery(), Statement.RETURN_GENERATED_KEYS);
        filterCondition.setConditionTo(statement);
        return statement;
    }
}