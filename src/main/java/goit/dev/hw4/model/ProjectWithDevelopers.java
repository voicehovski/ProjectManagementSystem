package goit.dev.hw4.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectWithDevelopers {
    private Project project;
    private List<Developer> developers;

    public ProjectWithDevelopers(Project project) {
        this.project = project;
        developers = new ArrayList<>();
    }

    public Project getProject() {
        return project;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void addDeveloper (Developer developer) {
        developers.add(developer);
    }
}
