package goit.dev.hw4.api.mapper;

import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.dto.ProjectDto;

public class ProjectMapper implements Mapper<ProjectDto, Project> {
    @Override
    public ProjectDto toDto (Project project) {
        return new ProjectDto(
                project.getId(),
                project.getName(),
                project.getStart(),
                project.getCompanyId(),
                project.getCustomerId(),
                project.getCost()
        );
    }

    @Override
    public Project toEntity(ProjectDto dto) {
        return new Project(
                dto.getId(),
                dto.getName(),
                dto.getStart(),
                dto.getCompanyId(),
                dto.getCustomerId(),
                dto.getCost()
        );
    }
}
