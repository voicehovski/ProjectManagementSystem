package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractDeleteQuery;
import goit.dev.hw4.query.condition.FilterCondition;

public class DeleteSkillRelationByDeveloperIdQuery extends AbstractDeleteQuery {
    public DeleteSkillRelationByDeveloperIdQuery(FilterCondition condition) {
        super(condition);
    }

    @Override
    public String getQuery() {
        return "DELETE FROM developers_to_skills WHERE developer_id = ?";
    }
}
