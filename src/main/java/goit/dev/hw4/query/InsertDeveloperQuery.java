package goit.dev.hw4.query;

import goit.dev.hw4.query.condition.FilterCondition;

public class InsertDeveloperQuery extends AbstractInsertQuery {

    public InsertDeveloperQuery(FilterCondition condition) {
        this .filterCondition = condition;
    }

    @Override
    public String getQuery() {
        return "INSERT INTO developers" +
                "(name, birth_date, birthplace, gender, salary)" +
                "VALUES (?,?,?,?::gender,?)";
    }
}
