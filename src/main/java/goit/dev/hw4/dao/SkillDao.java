package goit.dev.hw4.dao;

import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Skill;
import goit.dev.hw4.model.builder.DeveloperBuilder;
import goit.dev.hw4.model.builder.SkillBuilder;

import java.sql.*;
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
    private static final String SELECT_BY_TREND_QUERY = "SELECT " +
            "id, trend, level " +
            "FROM skills" +
            "WHERE trend = ?";
    private static final String SELECT_BY_LEVEL_QUERY = "SELECT " +
            "id, trend, level " +
            "FROM skills" +
            "WHERE level = ?::skill_level";

    private Connection connection;

    public Optional<Skill> select (Id id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
            statement .setLong(1, id.getId());
            return new SkillBuilder().createEntity(statement.executeQuery())
                    .stream()
                    .findFirst();   // Так правильно?
        } catch ( SQLException e ) {
            throw new RuntimeException ( e );
        }
    }

    public List<Skill> selectAll () {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
            return new SkillBuilder().createEntity(statement.executeQuery());
        } catch ( SQLException e ) {
            throw new RuntimeException ( e );
        }
    }

    public List<Skill> selectByTrend (String trend) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_TREND_QUERY);
            statement .setString(1, trend);
            return new SkillBuilder().createEntity(statement.executeQuery());
        } catch ( SQLException e ) {
            throw new RuntimeException ( e );
        }
    }

    public List<Skill> selectByLevel (String level) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_LEVEL_QUERY);
            statement .setString(1, level);
            return new SkillBuilder().createEntity(statement.executeQuery());
        } catch ( SQLException e ) {
            throw new RuntimeException ( e );
        }
    }

    public Id insert (Skill entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getTrend());
            statement.setString(2, entity.getLevel());

            statement.executeUpdate();
            return new Id ( fetchCreatedId(statement.getGeneratedKeys()) );
        } catch ( SQLException e ) {
            throw new RuntimeException ( e );
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
            throw new RuntimeException ( e );
        }
    }

    public int update (Skill entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, entity.getTrend());
            statement.setString(2, entity.getLevel());
            statement.setLong(3, entity.getId());
            return statement.executeUpdate();
        } catch ( SQLException e ) {
            throw new RuntimeException ( e );
        }
    }

    public int delete (Id id) {
        try {
            PreparedStatement deleteSkillStatement = connection.prepareStatement(DELETE_QUERY);
            deleteSkillStatement.setLong(1, id.getId());
            return deleteSkillStatement.executeUpdate();
        } catch ( SQLException e ) {
            throw new RuntimeException ( e );
        }
    }
}
