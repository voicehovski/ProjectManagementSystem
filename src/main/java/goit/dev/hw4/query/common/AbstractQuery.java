package goit.dev.hw4.query.common;

import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public abstract class AbstractQuery<R> implements Query<R> {
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

    @Override
    public List<R> createEntity(ResultSet rs) throws SQLException {
        return Collections.emptyList();
    }

}
