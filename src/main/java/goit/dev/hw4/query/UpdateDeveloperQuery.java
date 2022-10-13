package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractUpdateQuery;
import goit.dev.hw4.query.condition.FilterCondition;

public class UpdateDeveloperQuery extends AbstractUpdateQuery {

    public UpdateDeveloperQuery(FilterCondition filterCondition) {
        super(filterCondition);
    }

    @Override
    public String getQuery() {
        return
                "UPDATE developers " +
                "SET name = ?, birth_date = ?, birthplace = ?, gender = ?, salary = ? " +
                "WHERE id = ?";
    }
}
