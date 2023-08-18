package goit.dev.hw4.dao;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.builder.DeveloperBuilder;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class DeveloperDao {
    public static final String SELECT_ALL_QUERY = "SELECT " +
            "id, name, birth_date, birthplace, gender, salary " +
            "FROM developers";
    public static final String SELECT_QUERY = "SELECT " +
            "id, name, birth_date, birthplace, gender, salary " +
            "FROM developers" +
            "WHERE id = ?";
    public static final String INSERT_QUERY = "INSERT INTO developers" +
            "(name, birth_date, birthplace, gender, salary)" +
            "VALUES (?,?,?,?::gender,?)";
    public static final String UPDATE_QUERY = "UPDATE developers " +
            "SET name = ?, birth_date = ?, birthplace = ?, gender = ?::gender, salary = ? " +
            "WHERE id = ?";
    public static final String DELETE_QUERY = "DELETE FROM developers WHERE id = ?";
    public static final String DELETE_PROJECT_RELATION_QUERY = "DELETE FROM developers_to_projects WHERE developer_id = ?";
    public static final String DELETE_SKILL_RELATION_QUERY = "DELETE FROM developers_to_skills WHERE developer_id = ?";

    private Connection connection;

    public DeveloperDao(Connection connection) {
        this.connection = connection;
    }

    public Optional<Developer> select (int id ) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
        statement .setInt(1, id);
        return new DeveloperBuilder().createEntity(statement.executeQuery())
                .stream()
                .findFirst();
    }
    public List<Developer> selectAll (  ) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
        return new DeveloperBuilder().createEntity(statement.executeQuery());
    }
    public List<Developer> selectBySkill ( Long [] skillIds ) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_BY_SKILL_QUERY);
        return new DeveloperBuilder().createEntity(statement.executeQuery());
    }

    public int insert (Developer entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,entity.getName());
        statement.setDate(2, entity.getBirthDate());
        statement.setString(3,entity.getBirthPlace());
        statement.setString(4,entity.getGender());
        statement.setInt(5,entity.getSalary());

        statement.executeUpdate();
        return fetchCreatedId(statement.getGeneratedKeys());
    }
    private int fetchCreatedId(ResultSet keys) throws SQLException {
        if (keys.next()) {
            return keys.getInt("id");
        } else {
            throw new RuntimeException("No key was generated");
        }
    }
    public int update (Developer entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
        statement.setString(1, entity.getName());
        statement.setDate(2, entity.getBirthDate());
        statement.setString(3, entity.getBirthPlace());
        statement.setString(4, entity.getGender());
        statement.setInt(5, entity.getSalary());

        statement.setLong(6, entity.getId());

        return statement.executeUpdate();
    }
    public int delete (int id) throws SQLException {
        PreparedStatement deleteProjectRelationStatement = connection.prepareStatement(DELETE_PROJECT_RELATION_QUERY);
        deleteProjectRelationStatement .setInt(1, id);
        deleteProjectRelationStatement .executeQuery();

        PreparedStatement deleteSkillRelationStatement = connection.prepareStatement(DELETE_SKILL_RELATION_QUERY);
        deleteSkillRelationStatement.setInt(1, id);
        deleteSkillRelationStatement .executeQuery();

        PreparedStatement deleteDeveloperStatement = connection.prepareStatement(DELETE_QUERY);
        deleteDeveloperStatement.setInt(1, id);
        return deleteDeveloperStatement.executeUpdate();
    }
}
