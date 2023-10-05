package goit.dev.hw4.service;

import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.repository.ProjectRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class ProjectService {
    private ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> getAll () {
        return repository.getAll();
    }

    public Project get (Id projectId) {
        return repository.get(projectId).orElseThrow(
                () -> new NoSuchElementException("Project id: " + projectId .getId())
        );
    }

    public List<Project> getByName (String name) {
        return repository.getByName(name);
    }

    public List<Project> getWithDevelopersCount (  ) {
        return repository .getWithDevelopersCount();
    }

    public Id add ( Project project ) {
        // @q: Here some to check? Or make links? Or in controller? Or in command?
        return repository.add(project);
    }

}
