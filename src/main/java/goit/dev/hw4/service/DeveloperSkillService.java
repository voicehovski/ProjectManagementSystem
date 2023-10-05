package goit.dev.hw4.service;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.repository.DeveloperSkillRepository;

import java.util.List;

public class DeveloperSkillService {
    private DeveloperSkillRepository repository;

    public DeveloperSkillService(DeveloperSkillRepository repository) {
        this.repository = repository;
    }

    public List<Developer> getBySkillTrend (String trend ) {
        return repository .getBySkillTrend(trend);
    }

    public List<Developer> getBySkillLevel ( String level ) {
        return repository .getBySkillLevel(level);
    }
}
