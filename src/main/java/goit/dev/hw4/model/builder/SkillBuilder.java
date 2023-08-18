package goit.dev.hw4.model.builder;

import goit.dev.hw4.model.Skill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillBuilder implements EntityBuilder <Skill> {
    public List<Skill> createEntity(ResultSet rs) throws SQLException {
        List<Skill> skillList = new ArrayList<>();
        while (rs.next()){
            skillList.add(Skill.createFromResultSet(rs));
        }
        return skillList;
    }
}
