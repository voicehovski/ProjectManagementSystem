package goit.dev.hw4.service;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.repository.DeveloperProjectRepository;

import java.util.List;

public class DeveloperProjectService {
    private DeveloperProjectRepository repository;

    public DeveloperProjectService(DeveloperProjectRepository repository) {
        this.repository = repository;
    }

    public List<Developer> getByProject (Id projectId ) {
        return repository .getByProject(projectId);
    }

    // @q: Не сделать ли объект Number? С одной стороны, это просто число. С другой - у нас
    // вся информация передаётся объектами-сущностями. Можно сделать, например, сущсности для
    // Total, Count, Affected. Преимущества? Недостатки?
    public int getTotalSalaryByProject ( Id projectId ) {
        return repository .getTotalSalaryByProject(projectId);
    }
}
