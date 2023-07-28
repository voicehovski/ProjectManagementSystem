package goit.dev.hw4.service;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.query.common.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TotalSalaryService implements AgregateService<Integer> {
    private DatabaseManagerConnector connector;

    public TotalSalaryService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public Integer get(Query<Integer> query) {
        try (Connection connection = connector.createConnection()) {
            PreparedStatement statement = query.createStatement(connection);
            return query.createEntity(statement.executeQuery()).stream()
                    .findFirst()
                    .orElse(null);
        } catch (SQLException throwables) {
            throw new RuntimeException("Problems with query " + query .toString());
        }
    }
}
