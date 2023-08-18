package goit.dev.hw4.model.builder;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeveloperWithProjectsBuilder implements EntityBuilder<DeveloperWithProjects> {
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
