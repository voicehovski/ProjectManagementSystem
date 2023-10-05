package goit.dev.hw4.repository;

import goit.dev.hw4.dao.DeveloperDao;
import goit.dev.hw4.dao.SkillDao;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Skill;

import java.util.List;

public class DeveloperSkillRepository {
    private DeveloperDao developerDao;
    private SkillDao skillDao;

    public DeveloperSkillRepository(DeveloperDao developerDao, SkillDao skillDao) {
        this.developerDao = developerDao;
        this.skillDao = skillDao;
    }

    // @q: public List<DeveloperWithSkills> getBySkillTrend ( String trend ) {
    public List<Developer> getBySkillTrend (String trend ) {
        List<Skill> skills = skillDao .selectByTrend(trend);
        if ( skills .isEmpty() ) {
            throw new RuntimeException(String .format ( "No such trend [%s]", trend ));
        }
        // @q: return developerDao .selectWithSkill(skills .stream() ...
        return developerDao .selectBySkill(skills .stream()
                .map(Skill::getId) // skill -> skill.getId() можно и так
                .toArray(Id[]::new)
        );
    }

    public List<Developer> getBySkillLevel ( String level ) {
        List<Skill> skills = skillDao .selectByLevel(level);
        if ( skills .isEmpty() ) {
            throw new RuntimeException(String .format ( "No such level [%s]", level ));
        }
        return developerDao .selectBySkill(skills .stream()
                .map(Skill::getId)
                .toArray(Id[]::new)
        );
    }
}
