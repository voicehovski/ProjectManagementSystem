package goit.dev.hw4.query.executor;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQueryExecutor {
    private DatabaseManagerConnector connector;

    public DeleteQueryExecutor(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public void execute (Query query) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("");
        }

    }
}
