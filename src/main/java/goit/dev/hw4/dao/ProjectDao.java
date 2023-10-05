package goit.dev.hw4.dao;

import goit.dev.hw4.exception.SQLWrapperException;
import goit.dev.hw4.model.*;
import goit.dev.hw4.model.builder.ProjectBuilder;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProjectDao {
    public static final String SELECT_ALL_QUERY = "SELECT " +
            "id, name, start, company_id, customer_id, cost " +
            "FROM projects";
    public static final String SELECT_QUERY = "SELECT " +
            "id, name, start, company_id, customer_id, cost " +
            "FROM projects " +
            "WHERE id = ?";
    public static final String SELECT_BY_NAME_QUERY = "SELECT " +
            "id, name, start, company_id, customer_id, cost " +
            "FROM projects " +
            "WHERE name = ?";

    public static final String INSERT_QUERY = "INSERT INTO projects " +
            "(name, start, company_id, customer_id, cost) " +
            "VALUES (?,?,?,?,?) ";
    public static final String UPDATE_QUERY = "UPDATE projects " +
            "SET name = ?, start = ?, company_id = ?, customer_id = ?, cost = ? " +
            "WHERE id = ?";
    public static final String DELETE_QUERY = "DELETE FROM projects WHERE id = ?";
    public static final String DELETE_DEVELOPER_RELATION_QUERY = "DELETE FROM developers_to_projects WHERE project_id = ?";

    private Connection connection;

    public ProjectDao(Connection connection) {
        this.connection = connection;
    }

    public Optional<Project> select (Id id ) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
            statement.setLong(1, id.getId());
            return new ProjectBuilder().createEntity(statement.executeQuery())
                    .stream()
                    .findFirst();
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }

    public List<Project> selectAll (  ) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
            return new ProjectBuilder().createEntity(statement.executeQuery());
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }

    public List<Project> select (String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME_QUERY);
            statement.setString(1, name);
            return new ProjectBuilder().createEntity(statement.executeQuery())
                    .stream()
                    .collect(Collectors.toList());
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }

    public Id insert (Project entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getName());
            statement.setDate(2, entity.getStart());
            statement.setLong(3, entity.getCompanyId());
            statement.setLong(4, entity.getCustomerId());
            statement.setInt(5, entity.getCost());

            statement.executeUpdate();
            return new Id ( fetchCreatedId(statement.getGeneratedKeys()) );
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }
    private int fetchCreatedId(ResultSet keys) {
        try {
            if (keys.next()) {
                return keys.getInt("id");
            } else {
                throw new RuntimeException("No key was generated");
            }
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }
    public int update (Project entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, entity.getName());
            statement.setDate(2, entity.getStart());
            statement.setLong(3, entity.getCompanyId());
            statement.setLong(4, entity.getCustomerId());
            statement.setInt(5, entity.getCost());

            statement.setLong(6, entity.getId().getId());

            return statement.executeUpdate();
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }
    public int delete (Id id) {
        try {
            // Нужно ли контроллировать?
            // Завернуть все в транзакцию?
            PreparedStatement deleteDeveloperRelationStatement = connection.prepareStatement(DELETE_DEVELOPER_RELATION_QUERY);
            deleteDeveloperRelationStatement .setLong(1, id.getId());
            deleteDeveloperRelationStatement .executeQuery();

            PreparedStatement deleteProjectStatement = connection.prepareStatement(DELETE_QUERY);
            deleteProjectStatement.setLong(1, id.getId());
            return deleteProjectStatement.executeUpdate();
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }
}
