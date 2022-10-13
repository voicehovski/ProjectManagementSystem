package goit.dev.hw4.query;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.query.common.AbstractQuery;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDeveloperBySkillTrendQuery extends AbstractQuery<Developer> {
    public static final String QUERY = "SELECT DISTINCT " +
            "developer.id, name, birth_date, birthplace, gender, salary " +

            "FROM developers_to_skills AS d2s " +
            "INNER JOIN developers AS developer ON d2s.developer_id = developer.id " +
            "INNER JOIN skills AS skill ON d2s.skill_id = skill.id " +

            "WHERE trend = ?";

    public SelectDeveloperBySkillTrendQuery(FilterCondition filterCondition) {
        this.filterCondition = filterCondition;
    }

    @Override
    public String getQuery() {
        return QUERY;
    }

    public List<Developer> createEntity (ResultSet rs) throws SQLException {
        List<Developer> developerEntityList = new ArrayList<>();    // Задать размер?
        while (rs.next()){
            developerEntityList.add( Developer.createFromResultSet(rs) );
        }
        return developerEntityList;
    }
}

