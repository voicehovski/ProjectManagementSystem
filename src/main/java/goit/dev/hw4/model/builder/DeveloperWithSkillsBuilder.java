package goit.dev.hw4.model.builder;

import goit.dev.hw4.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeveloperWithSkillsBuilder implements EntityBuilder<DeveloperWithSkills> {
        @Override
        public List<DeveloperWithSkills> createEntity(ResultSet rs) throws SQLException {
            Map<Long, DeveloperWithSkills> map = new HashMap<>();
            while (rs.next()){
                Long developerId = rs.getLong("d.id");
                if (!map.containsKey(developerId)) {
                    map.put(developerId, new DeveloperWithSkills(createDeveloperFromResultSet(rs)));
                }
                map.get(developerId).addSkill(createProjectFromResultSet(rs));
            }
            return new ArrayList<>(map.values());
        }

        private Skill createProjectFromResultSet (ResultSet rs) throws SQLException {
            return new Skill(
                    rs.getLong("s.id"),
                    rs.getString("trend"),
                    rs.getString("level")

            );
        }
        private Developer createDeveloperFromResultSet (ResultSet rs) throws SQLException {
            return new Developer(
                    rs.getLong("d.id"),
                    rs.getString("name"),
                    rs.getDate("birth_date"),
                    rs.getString("birthplace"),
                    rs.getString("gender"),
                    rs.getInt("salary")
            );
        }
}
