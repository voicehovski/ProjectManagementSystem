package goit.dev.hw4.query;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.ProjectWithDevelopers;
import goit.dev.hw4.query.common.AbstractSelectQuery;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectProjectWithDevelopersQuery extends AbstractSelectQuery<ProjectWithDevelopers> {
    public static final String QUERY = "SELECT " +
            "developer.id AS developer_id, developer.name AS developer_name, birth_date, birthplace, gender, salary, " +
            "project.id as project_id, project.name AS project_name, start, company_id, customer_id, cost " +

            "FROM developers_to_projects AS d2p " +
            "INNER JOIN developers AS developer ON d2p.developer_id = developer.id " +
            "INNER JOIN projects AS project ON d2p.project_id = project.id";

    public SelectProjectWithDevelopersQuery() {
        super(statement -> {});
    }

    // Это нужно поскольку в подклассах с фильтрацией конструктор из AbstractSelectQuery недоступен
    public SelectProjectWithDevelopersQuery(FilterCondition condition) {
        super(condition);
    }

    @Override
    public String getQuery() {
        return QUERY;
    }

    @Override
    public List<ProjectWithDevelopers> createEntity(ResultSet rs) throws SQLException {
        Map<Long, ProjectWithDevelopers> map = new HashMap<>();
        while (rs.next()){
            Long projectId = rs.getLong("project_id");
            if (!map.containsKey(projectId)) {
                map.put(projectId, new ProjectWithDevelopers(createProjectFromResultSet(rs)));
            }
            map.get(projectId).addDeveloper(createDeveloperFromResultSet(rs));
        }
        return new ArrayList<>(map.values());
    }

    private Project createProjectFromResultSet (ResultSet rs) throws SQLException {
        return new Project(
                rs.getLong("project_id"),
                rs.getString("project_name"),
                rs.getDate("start"),
                rs.getLong("company_id"),
                rs.getLong("customer_id"),
                rs.getInt("cost")

        );
    }
    private Developer createDeveloperFromResultSet (ResultSet rs) throws SQLException {
        return new Developer(
                rs.getLong("developer_id"),
                rs.getString("developer_name"),
                rs.getDate("birth_date"),
                rs.getString("birthplace"),
                rs.getString("gender"),
                rs.getInt("salary")
        );
    }
}
