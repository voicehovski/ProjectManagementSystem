package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractDeleteQuery;
import goit.dev.hw4.query.condition.FilterCondition;

public class DeleteDeveloperQuery extends AbstractDeleteQuery {
    public DeleteDeveloperQuery(FilterCondition condition) {
        super(condition);
    }

    @Override
    public String getQuery() {
        return "DELETE FROM developers WHERE id = ?";
    }
}
