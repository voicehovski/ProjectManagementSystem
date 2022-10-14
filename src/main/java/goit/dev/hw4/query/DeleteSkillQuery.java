package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractDeleteQuery;
import goit.dev.hw4.query.condition.FilterCondition;

public class DeleteSkillQuery extends AbstractDeleteQuery {

    public DeleteSkillQuery(FilterCondition filterCondition) {
        super(filterCondition);
    }

    @Override
    public String getQuery() {
        return "DELETE FROM skills WHERE id = ?";
    }
}
