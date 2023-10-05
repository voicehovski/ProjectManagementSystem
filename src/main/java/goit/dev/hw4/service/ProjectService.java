package goit.dev.hw4.service;

import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.repository.ProjectRepository;

import java.util.List;

public class ProjectService {
    private ProjectRepository repository;

    public List<Project> getWithDevelopersCount (  ) {
        return repository .getWithDevelopersCount();
    }

    public Id add ( Project project ) {
        // Here some to check? Or make links? Or in controller? Or in command?
        return repository.add(project);
    }

}
