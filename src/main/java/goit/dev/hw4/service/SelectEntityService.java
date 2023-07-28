package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.common.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SelectEntityService<E> implements SelectService<E> {
    DatabaseManagerConnector connector;

    public SelectEntityService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    // todo method should take more specific type, like Abstract(Select)Query<E>. How?
    public List<E> select (Query<E> query) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            return query.createEntity(statement.executeQuery());
        } catch (SQLException throwables) {
            throw new RuntimeException("Problems with query " + query .toString());
        }
    }
}
