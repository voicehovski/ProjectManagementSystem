package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractSelectQuery;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

// todo Криво. Сделать отдельный тип Query который возвращает скалярное значение. А для групп?
public class TotalSalaryQuery extends AbstractSelectQuery {

    public TotalSalaryQuery(FilterCondition condition) {
        super(condition);
    }

    @Override
    public String getQuery() {
        return "SELECT " +
                "sum(salary) AS total " +

                "FROM developers " +
                "INNER JOIN developers_to_projects ON developers.id = developer_id " +

                "WHERE project_id = ?";
    }
}
