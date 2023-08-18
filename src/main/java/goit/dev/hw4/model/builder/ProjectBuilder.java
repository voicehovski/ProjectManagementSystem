package goit.dev.hw4.model.builder;

import goit.dev.hw4.model.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectBuilder implements EntityBuilder <Project> {
    public List<Project> createEntity(ResultSet rs) throws SQLException {
        List<Project> projectList = new ArrayList<>();
        while (rs.next()){
            projectList.add(Project.createFromResultSet(rs));
        }
        return projectList;
    }
}
