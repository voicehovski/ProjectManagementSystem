package goit.dev.hw4.query;

import goit.dev.hw4.model.Project;
import goit.dev.hw4.query.common.AbstractSelectQuery;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectProjectQuery extends AbstractSelectQuery {

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
}
