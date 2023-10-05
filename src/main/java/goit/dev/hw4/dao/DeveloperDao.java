package goit.dev.hw4.dao;

import goit.dev.hw4.exception.SQLWrapperException;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithSkills;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.ProjectWithDevelopers;
import goit.dev.hw4.model.builder.AgregateNumberBuilder;
import goit.dev.hw4.model.builder.DeveloperBuilder;
import goit.dev.hw4.model.builder.DeveloperWithSkillsBuilder;
import goit.dev.hw4.model.builder.ProjectWithDevelopersBuilder;

import java.sql.*;
import java.util.Arrays;
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
    public static final String SELECT_WITH_SKILL_QUERY = "SELECT " +
            "d.id, name, birth_date, birthplace, gender, salary " +
            "s.id, s.trend, s.level " +
            "FROM developers d " +
            "INNER JOIN developers_to_skills dts ON dts.developer_id = d.id " +
            "INNER JOIN skills s ON dts.skill_id = s.id " +
            "WHERE skill_id in (?)";
    public static final String SELECT_BY_SKILL_QUERY = "SELECT " +
            "d.id, name, birth_date, birthplace, gender, salary " +
            "FROM developers d " +
            "INNER JOIN developers_to_skills dts ON dts.developer_id = d.id " +
            "WHERE dts.skill_id in (?)";
    private static final String SELECT_WITH_PROJECT_QUERY = "SELECT " +
            "d.id, name, birth_date, birthplace, gender, salary " +
            "p.id, p.name, p.start, p.company_id, p.customer_id, cost " +
            "FROM developers d " +
            "INNER JOIN developers_to_projects dtp ON dtp.developer_id = d.id " +
            "INNER JOIN projects p ON dtp.project_id = p.id " +
            "WHERE project_id in (?)";
    private static final String SELECT_BY_PROJECT_QUERY = "SELECT " +
            "d.id, name, birth_date, birthplace, gender, salary " +
            "FROM developers d " +
            "INNER JOIN developers_to_projects dtp ON dtp.developer_id = d.id " +
            "WHERE dtp.project_id in (?)";
    public static final String AGREGATE_TOTAL_SALARY_BY_PROJECT_QUERY = "SELECT sum(salary) AS total FROM developers d " +
            "INNER JOIN developers_to_projects dtp ON dtp.developer_id = d.id " +
            "WHERE dtp.project_id in (?)";
    // Использую имя total чтобы согласовать с AgregateNumberBuilder. Не красиво...
    public static final String AGREGATE_COUNT_BY_PROJECT_QUERY = "SELECT count(*) AS total FROM developers d " +
            "INNER JOIN developers_to_projects dtp ON dtp.developer_id = d.id " +
            "WHERE dtp.project_id = ?";

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

    public Optional<Developer> select (Id id ) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
            statement.setLong(1, id.getId());
            return new DeveloperBuilder().createEntity(statement.executeQuery())
                    .stream()
                    .findFirst();   // @q: Может тут нужен контроль - несколько с одинаковым ИД?
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }

    public List<Developer> selectAll (  ) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
            return new DeveloperBuilder().createEntity(statement.executeQuery());
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }

    // @q: Possibly formats of relation query result
    // [{Developer, List<Skill>}], DeveloperWithSkills
    // [{Developer, Skill}], DeveloperAndSkill
    // [{Skill, List<Developer>}]
    public List<DeveloperWithSkills> selectWithSkill (Id [] skillIds ) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_WITH_SKILL_QUERY);
            // Does such conversion work?
            statement .setString(1, String .join(",", Arrays .asList(skillIds) .toArray(new String[0])));
            return new DeveloperWithSkillsBuilder().createEntity(statement.executeQuery());
        } catch ( SQLException e ) {
            throw new SQLWrapperException ( e );
        }
    }
    public List<Developer> selectBySkill (Id [] skillIds ) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_SKILL_QUERY);
            statement .setString(1, String .join(",", Arrays .asList(skillIds) .toArray(new String[0])));
            return new DeveloperBuilder().createEntity(statement.executeQuery());
        } catch ( SQLException e ) {
            throw new SQLWrapperException ( e );
        }
    }

    public List<ProjectWithDevelopers> selectWithProject (Id [] projectIds ) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_WITH_PROJECT_QUERY);
            statement .setString(1, String .join(",", Arrays .asList(projectIds) .toArray(new String[0])));
            return new ProjectWithDevelopersBuilder().createEntity(statement.executeQuery());
        } catch ( SQLException e ) {
            throw new SQLWrapperException ( e );
        }
    }
    public List<Developer> selectByProject (Id [] projectIds ) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_PROJECT_QUERY);
            statement .setString(1, String .join(",", Arrays .asList(projectIds) .toArray(new String[0])));
            return new DeveloperBuilder().createEntity(statement.executeQuery());
        } catch ( SQLException e ) {
            throw new SQLWrapperException ( e );
        }
    }

    // @q: Здесь нужен массив? Другими словами, нам нужна возможность получить сумму зарплат по нескольким проектам?
    public Optional<Integer> agregateTotalSalaryByProject (Id [] projectIds ) {
        try {
            PreparedStatement statement = connection.prepareStatement(AGREGATE_TOTAL_SALARY_BY_PROJECT_QUERY);
            statement .setString(1, String .join(",", Arrays .asList(projectIds) .toArray(new String[0])));
            return new AgregateNumberBuilder().createEntity(statement.executeQuery()).stream()
                    .findFirst();
        } catch ( SQLException e ) {
            throw new SQLWrapperException ( e );
        }
    }

    // @q: Что вернет если на проекте нет разработчиков? Null или 0 ?
    public Optional<Integer> agregateCount (Id projectId) {
        try {
            PreparedStatement statement = connection.prepareStatement(AGREGATE_COUNT_BY_PROJECT_QUERY);
            statement.setLong(1, projectId.getId());
            return new AgregateNumberBuilder().createEntity(statement.executeQuery())
                    .stream()
                    .findFirst();
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }

    public Id insert (Developer entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,entity.getName());
            statement.setDate(2, entity.getBirthDate());
            statement.setString(3,entity.getBirthPlace());
            statement.setString(4,entity.getGender());
            statement.setInt(5,entity.getSalary());

            statement.executeUpdate();
            return new Id (fetchCreatedId(statement.getGeneratedKeys()));
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
    public int update (Developer entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, entity.getName());
            statement.setDate(2, entity.getBirthDate());
            statement.setString(3, entity.getBirthPlace());
            statement.setString(4, entity.getGender());
            statement.setInt(5, entity.getSalary());

            statement.setLong(6, entity.getId().getId());

            return statement.executeUpdate();
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }
    public int delete (Id id) {
        try {
            PreparedStatement deleteProjectRelationStatement = connection.prepareStatement(DELETE_PROJECT_RELATION_QUERY);
            deleteProjectRelationStatement .setLong(1, id.getId());
            deleteProjectRelationStatement .executeQuery();

            PreparedStatement deleteSkillRelationStatement = connection.prepareStatement(DELETE_SKILL_RELATION_QUERY);
            deleteSkillRelationStatement.setLong(1, id.getId());
            deleteSkillRelationStatement .executeQuery();

            PreparedStatement deleteDeveloperStatement = connection.prepareStatement(DELETE_QUERY);
            deleteDeveloperStatement.setLong(1, id.getId());
            return deleteDeveloperStatement.executeUpdate();
        } catch ( SQLException e ) {
            throw new SQLWrapperException( e );
        }
    }
}
