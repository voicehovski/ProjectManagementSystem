package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractUpdateQuery;
import goit.dev.hw4.query.condition.FilterCondition;

public class UpdateSkillQuery extends AbstractUpdateQuery {
    public UpdateSkillQuery(FilterCondition filterCondition) {
        super(filterCondition);
    }

    @Override
    public String getQuery() {
        return
                "UPDATE skills " +
                        "SET trend = ?, level = ?::skill_level " +
                        "WHERE id = ?";
    }
}
