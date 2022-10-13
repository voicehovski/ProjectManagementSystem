package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractDeleteQuery;
import goit.dev.hw4.query.condition.FilterCondition;

public class DeleteProjectRelationByDeveloperIdQuery extends AbstractDeleteQuery {
    public DeleteProjectRelationByDeveloperIdQuery(FilterCondition condition) {
        this .filterCondition = condition;
    }

    @Override
    public String getQuery() {
        return "DELETE FROM developers_to_projects WHERE developer_id = ?";
    }
}
