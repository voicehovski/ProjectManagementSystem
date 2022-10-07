package goit.dev.hw4.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ProjectWithDevelopersDto {
    private ProjectDto project;
    private List<DeveloperDto> developerList;

    public ProjectWithDevelopersDto(ProjectDto project) {
        this.project = project;
        developerList = new ArrayList<>();
    }

    public ProjectDto getProject() {
        return project;
    }

    public List<DeveloperDto> getDeveloperList() {
        return developerList;
    }

    public void addDeveloper(DeveloperDto developer) {
        developerList.add(developer);
    }
}
