package goit.dev.hw4.query;

import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.Skill;
import goit.dev.hw4.query.common.AbstractQuery;
import goit.dev.hw4.query.condition.FilterCondition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectSkillQuery extends AbstractQuery<Skill> {
    public SelectSkillQuery() {
        super(statement -> {});
    }

    @Override
    public String getQuery() {
        return "SELECT " +
                "id, trend, level " +
                "FROM skills";
    }

    @Override
    public List<Skill> createEntity(ResultSet rs) throws SQLException {
        List<Skill> skillList = new ArrayList<>();
        while (rs.next()){
            skillList.add(Skill.createFromResultSet(rs));
        }
        return skillList;
    }
}
