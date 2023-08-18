package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.builder.EntityBuilder;
import goit.dev.hw4.query.common.AbstractSelectQuery;
import goit.dev.hw4.query.common.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SelectEntityService implements SelectService {
    DatabaseManagerConnector connector;

    public SelectEntityService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public <E> List<E> select (AbstractSelectQuery query, EntityBuilder<E> builder) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            return builder.createEntity(statement.executeQuery());
        } catch (SQLException throwables) {
            throw new RuntimeException("Problems with query " + query .toString());
        }
    }
}
