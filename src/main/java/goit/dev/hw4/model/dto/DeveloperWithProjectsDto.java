package goit.dev.hw4.model.dto;

import java.util.ArrayList;
import java.util.List;

public class DeveloperWithProjectsDto {
    private DeveloperDto developer;
    private List<ProjectDto> projectList;

    public DeveloperWithProjectsDto(DeveloperDto developer) {
        this.developer = developer;
        this.projectList = new ArrayList<>();
    }

    public DeveloperDto getDeveloper() {
        return developer;
    }

    public List<ProjectDto> getProjectList() {
        return projectList;
    }

    public void addProject(ProjectDto project){
        projectList.add(project);
    }
}
