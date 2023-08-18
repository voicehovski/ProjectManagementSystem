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

public class SelectProjectWithDevelopersQuery extends AbstractSelectQuery {
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

}
