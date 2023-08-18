package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractSelectQuery;
import goit.dev.hw4.query.condition.FilterCondition;


public class SelectDeveloperWithProjectsQuery extends AbstractSelectQuery {
    public static final String QUERY = "SELECT " +
            "developer.id AS developer_id, developer.name AS developer_name, birth_date, birthplace, gender, salary, " +
            "project.id as project_id, project.name AS project_name, start, company_id, customer_id, cost " +

            "FROM developers_to_projects AS d2p " +
            "INNER JOIN developers AS developer ON d2p.developer_id = developer.id " +
            "INNER JOIN projects AS project ON d2p.project_id = project.id";

    public SelectDeveloperWithProjectsQuery() {
        super(statement -> {});
    }

    // Это нужно поскольку в подклассах с фильтрацией конструктор из AbstractSelectQuery недоступен
    public SelectDeveloperWithProjectsQuery(FilterCondition condition) {
        super(condition);
    }

    @Override
    public String getQuery() {
        return QUERY;
    }
}
