package goit.dev.hw4.query.executor;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgreagteQueryExecutor<R> {
    private DatabaseManagerConnector connector;

    public AgreagteQueryExecutor(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public R execute (Query<R> query) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            return query.createEntity(statement.executeQuery()).stream()
                    .findFirst()
                    .orElse(null);
        } catch (SQLException throwables) {
            throw new RuntimeException("");
        }

    }
}