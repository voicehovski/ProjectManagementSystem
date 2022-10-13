package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractQuery;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class TotalSalaryQuery extends AbstractQuery<Integer> {

    public TotalSalaryQuery(FilterCondition condition) {
        this .filterCondition = condition;
    }

    @Override
    public String getQuery() {
        return "SELECT " +
                "sum(salary) AS total " +

                "FROM developers " +
                "INNER JOIN developers_to_projects ON developers.id = developer_id " +

                "WHERE project_id = ?";
    }

    @Override
    public List<Integer> createEntity(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return List.of(rs.getInt("total"));
        }
        return Collections.emptyList();
    }
}
