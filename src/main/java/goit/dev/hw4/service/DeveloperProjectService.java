package goit.dev.hw4.service;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.repository.DeveloperProjectRepository;

import java.util.List;

public class DeveloperProjectService {
    private DeveloperProjectRepository repository;

    public List<Developer> getByProject ( Id id ) {
        return repository .getByProject(id);
    }

    public int getTotalSalaryByProject ( Id id ) {
        return repository .getTotalSalaryByProject(id);
    }
}
