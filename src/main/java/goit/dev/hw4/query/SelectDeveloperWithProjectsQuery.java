package goit.dev.hw4.query;

import goit.dev.hw4.model.*;
import goit.dev.hw4.query.common.AbstractQuery;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectDeveloperWithProjectsQuery extends AbstractQuery<DeveloperWithProjects> {
    public static final String QUERY = "SELECT " +
            "developer.id AS developer_id, developer.name AS developer_name, birth_date, birthplace, gender, salary, " +
            "project.id as project_id, project.name AS project_name, start, company_id, customer_id, cost " +

            "FROM developers_to_projects AS d2p " +
            "INNER JOIN developers AS developer ON d2p.developer_id = developer.id " +
            "INNER JOIN projects AS project ON d2p.project_id = project.id";

    public SelectDeveloperWithProjectsQuery() {
        super(statement -> {});
    }

    // Это нужно поскольку в подклассах с фильтрацией конструктор из AbstractQuery недоступен
    public SelectDeveloperWithProjectsQuery(FilterCondition condition) {
        super(condition);
    }

    @Override
    public String getQuery() {
        return QUERY;
    }

    @Override
    public List<DeveloperWithProjects> createEntity(ResultSet rs) throws SQLException {
        Map<Long, DeveloperWithProjects> map = new HashMap<>();
        while (rs.next()){
            Long developerId = rs.getLong("developer_id");
            if (!map.containsKey(developerId)) {
                map.put(developerId, new DeveloperWithProjects(createDeveloperFromResultSet(rs)));
            }
            map.get(developerId).addProject(createProjectFromResultSet(rs));
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
