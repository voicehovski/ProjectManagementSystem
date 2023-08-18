package goit.dev.hw4.model.builder;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.ProjectWithDevelopers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectWithDevelopersBuilder implements EntityBuilder <ProjectWithDevelopers> {

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
