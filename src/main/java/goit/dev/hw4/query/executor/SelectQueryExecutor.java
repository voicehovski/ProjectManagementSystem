package goit.dev.hw4.query.executor;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.common.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SelectQueryExecutor<R> {
    private DatabaseManagerConnector connector;

    public SelectQueryExecutor(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public List<R> execute (Query<R> query) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            return query.createEntity(statement.executeQuery());
        } catch (SQLException throwables) {
            throw new RuntimeException("");
        }

    }
}