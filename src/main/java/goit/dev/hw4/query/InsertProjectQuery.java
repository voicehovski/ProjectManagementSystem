package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractInsertQuery;
import goit.dev.hw4.query.condition.FilterCondition;

public class InsertProjectQuery extends AbstractInsertQuery {
    public InsertProjectQuery(FilterCondition filterCondition) {
        super(filterCondition);
    }

    @Override
    public String getQuery() {
        return "INSERT INTO projects " +
                "(name, start, company_id, customer_id, cost) " +
                "VALUES (?,?,?,?,?) ";
    }
}
