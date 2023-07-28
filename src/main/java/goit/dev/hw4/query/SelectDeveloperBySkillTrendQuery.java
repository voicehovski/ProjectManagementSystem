package goit.dev.hw4.query;

import goit.dev.hw4.query.condition.FilterCondition;

public class SelectDeveloperBySkillTrendQuery extends SelectDeveloperQuery {
    public static final String QUERY = "SELECT DISTINCT " +
            "developer.id, name, birth_date, birthplace, gender, salary " +

            "FROM developers_to_skills AS d2s " +
            "INNER JOIN developers AS developer ON d2s.developer_id = developer.id " +
            "INNER JOIN skills AS skill ON d2s.skill_id = skill.id " +

            "WHERE trend = ?";

    public SelectDeveloperBySkillTrendQuery(FilterCondition condition) {
        super(condition);
    }

    @Override
    public String getQuery() {
        return QUERY;
    }
}

