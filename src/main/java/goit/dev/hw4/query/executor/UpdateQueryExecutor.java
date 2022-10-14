package goit.dev.hw4.query.executor;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.common.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// todo То же что и в DeleteQueryExecutor. Может свести в один?
public class UpdateQueryExecutor {
    private DatabaseManagerConnector connector;

    public UpdateQueryExecutor(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public void execute (Query query) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            throw new RuntimeException("");
        }

    }
}
