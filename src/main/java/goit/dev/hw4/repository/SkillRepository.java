package goit.dev.hw4.repository;

import goit.dev.hw4.dao.SkillDao;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Skill;

import java.util.List;
import java.util.Optional;

public class SkillRepository {
    private SkillDao skillDao;

    public SkillRepository(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    public List<Skill> getAll () {
        return skillDao .selectAll();
    }
    public Optional<Skill> get (Id id) {
        return skillDao .select(id);
    }
    public List<Skill> getByName (String name) {
        return skillDao .selectByTrend(name);
    }
    public List<Skill> getByLevel (String level) {
        return skillDao .selectByLevel(level);
    }

    public Id add (Skill entity) {
        return skillDao.insert(entity);
    }
    public int put (Skill entity) {
        return skillDao .update(entity);
    }
    public int remove (Id id) {
        return skillDao .delete(id);
    }
}
