package goit.dev.hw4.query;

import goit.dev.hw4.query.condition.FilterCondition;

public class SelectProjectByProjectNameQuery extends SelectProjectQuery {
    public SelectProjectByProjectNameQuery(FilterCondition condition) {
        super(condition);
    }

    @Override
    public String getQuery() {
        return "SELECT " +
                "id, name, start, company_id, customer_id, cost " +
                "FROM projects " +
                "WHERE name = ?";
    }
}
