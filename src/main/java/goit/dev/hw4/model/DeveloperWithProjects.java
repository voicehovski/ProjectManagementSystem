package goit.dev.hw4.model;

import java.util.ArrayList;
import java.util.List;
// todo generify
public class DeveloperWithProjects {
    private Developer developer;
    private List<Project> projects;

    public DeveloperWithProjects(Developer developer, List<Project> projects) {
        this.developer = developer;
        this.projects = projects;
    }

    public DeveloperWithProjects(Developer developer) {
        this.developer = developer;
        this.projects = new ArrayList<>();
    }

    public Developer getDeveloper() {
        return developer;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject (Project Project) {
        projects.add(Project);
    }
}
