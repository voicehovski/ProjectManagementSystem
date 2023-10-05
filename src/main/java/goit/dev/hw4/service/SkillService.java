package goit.dev.hw4.service;

import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Skill;
import goit.dev.hw4.repository.SkillRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class SkillService {

    private SkillRepository repository;

    public SkillService(SkillRepository repository) {
        this.repository = repository;
    }

    public List<Skill> getAll () {
        return  repository .getAll();
    }

    public Skill get (Id skillId) {
        return repository .get(skillId) .orElseThrow(
                () -> new NoSuchElementException("Skill id: " + skillId.getId())
        );
    }

    public Id add (Skill skill) {
        return repository .add(skill);
    }

    public int put (Skill skill) {
        return repository.put(skill);
    }

    public int remove (Id skillId) {
        return repository.remove(skillId);
    }
}
