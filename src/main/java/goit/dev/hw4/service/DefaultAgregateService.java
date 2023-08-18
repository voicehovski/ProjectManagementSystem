package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.builder.EntityBuilder;
import goit.dev.hw4.query.common.AbstractSelectQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DefaultAgregateService implements AgregateService {
    private DatabaseManagerConnector connector;

    public DefaultAgregateService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public <E> E get(AbstractSelectQuery query, EntityBuilder<E> builder) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            return builder.createEntity(statement.executeQuery()).stream()
                    .findFirst()
                    .orElse(null);
        } catch (SQLException throwables) {
            throw new RuntimeException("Problems with query " + query .toString());
        }
    }
}
