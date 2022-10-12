package goit.dev.hw4.query;

import goit.dev.hw4.query.condition.FilterCondition;

public class DeleteSkillRelationQuery extends AbstractDeleteQuery {
    public DeleteSkillRelationQuery(FilterCondition condition) {
        this .filterCondition = condition;
    }

    @Override
    public String getQuery() {
        return "DELETE FROM developers_to_skills WHERE developer_id = ?";
    }
}
