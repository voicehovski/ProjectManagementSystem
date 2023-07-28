package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.common.AbstractUpdateQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEntityService implements UpdateService {
    DatabaseManagerConnector connector;

    public UpdateEntityService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public int update (AbstractUpdateQuery query) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            return statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Problems with query " + query .toString());
        }
    }
}
