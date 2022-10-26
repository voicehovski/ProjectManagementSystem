package goit.dev.hw4.query;

import goit.dev.hw4.query.common.AbstractInsertQuery;
import goit.dev.hw4.query.condition.FilterCondition;

public class InsertSkillQuery extends AbstractInsertQuery {

    public InsertSkillQuery(FilterCondition filterCondition) {
        super(filterCondition);
    }

    @Override
    public String getQuery() {
        return "INSERT INTO skills " +
                "(trend, level) " +
                "VALUES (?,?::skill_level)";
    }
}
