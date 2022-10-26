package goit.dev.hw4.query;

import goit.dev.hw4.model.Project;
import goit.dev.hw4.query.common.AbstractQuery;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectProjectQuery extends AbstractQuery<Project> {

    public SelectProjectQuery() {
        super(statement -> {});
    }

    public SelectProjectQuery(FilterCondition condition) {super(condition);}

    @Override
    public String getQuery() {
        return "SELECT " +
                "id, name, start, company_id, customer_id, cost " +
                "FROM projects";
    }

    @Override
    public List createEntity(ResultSet rs) throws SQLException {
        List<Project> projectList = new ArrayList<>();
        while (rs.next()){
            projectList.add(Project.createFromResultSet(rs));
        }
        return projectList;
    }
}
