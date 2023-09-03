package goit.dev.hw4.dao;

import goit.dev.hw4.model.Skill;
import goit.dev.hw4.model.builder.DeveloperBuilder;
import goit.dev.hw4.model.builder.SkillBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class SkillDao {

    public static final String SELECT_ALL_QUERY = "SELECT " +
            "id, trend, level " +
            "FROM skills";
    public static final String SELECT_QUERY = "SELECT " +
            "id, trend, level " +
            "FROM skills" +
            "WHERE id = ?";
    public static final String INSERT_QUERY = "INSERT INTO skills " +
            "(trend, level) " +
            "VALUES (?,?::skill_level)";
    public static final String UPDATE_QUERY = "UPDATE skills " +
            "SET trend = ?, level = ?::skill_level " +
            "WHERE id = ?";
    public static final String DELETE_QUERY = "DELETE FROM skills WHERE id = ?";

    private Connection connection;

    public Optional<Skill> select (int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
        statement .setInt(1, id);
        return new SkillBuilder().createEntity(statement.executeQuery())
                .stream()
                .findFirst();
    }

    public List<Skill> selectAll () throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
        return new SkillBuilder().createEntity(statement.executeQuery());
    }

    public int insert (Skill entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, entity.getTrend());
        statement.setString(2, entity.getLevel());

        statement.executeUpdate();
        return fetchCreatedId(statement.getGeneratedKeys());
    }

    public int update (Skill entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
        statement.setString(1, entity.getTrend());
        statement.setString(2, entity.getLevel());
        statement.setLong(3, entity.getId());
        return statement.executeUpdate();
    }

    public int delete (int id) throws SQLException {
        PreparedStatement deleteSkillStatement = connection.prepareStatement(DELETE_QUERY);
        deleteSkillStatement.setInt(1, id);
        return deleteSkillStatement.executeUpdate();
    }
}
