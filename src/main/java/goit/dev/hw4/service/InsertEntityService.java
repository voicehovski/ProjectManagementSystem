package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.common.AbstractInsertQuery;
import goit.dev.hw4.query.common.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertEntityService implements InsertService {
    DatabaseManagerConnector connector;

    public InsertEntityService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public long insert(AbstractInsertQuery query) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            statement.executeUpdate();
            return fetchCreatedId(statement.getGeneratedKeys());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    private long fetchCreatedId(ResultSet keys) throws SQLException {
        if (keys.next()) {
            return keys.getLong("id");
        } else {
            throw new RuntimeException("No key was generated");
        }
    }
}
