package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.common.AbstractDeleteQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEntityService implements DeleteService {
    DatabaseManagerConnector connector;

    public DeleteEntityService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public void delete(AbstractDeleteQuery query) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Problems with query " + query .toString());
        }
    }
}
