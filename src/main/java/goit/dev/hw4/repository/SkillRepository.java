package goit.dev.hw4.repository;

import goit.dev.hw4.dao.DeveloperDao;
import goit.dev.hw4.dao.SkillDao;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Skill;

import java.util.List;

public class SkillRepository {
    private DeveloperDao developerDao;
    private SkillDao skillDao;

    public void add (Skill entity) {}
    public Skill get (int id) {}
    public List<Skill> getAll () {}
    public List<Skill> getByName (String name) {}
    public List<Skill> getByLevel (String level) {}
    public List<Developer> getDeveloper (List<Skill> entities) {
        developerDao .selectBySkill(entities .stream ()
                .map(skill -> skill .getId())
                .toArray(Long[]::new)
        );
    }
    public void put (Skill entity) {}
    public void remove (int id) {}
}
