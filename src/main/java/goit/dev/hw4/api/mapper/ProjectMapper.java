package goit.dev.hw4.api.mapper;

import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.ProjectDto;

public class ProjectMapper implements Mapper<ProjectDto, Project> {
    @Override
    public ProjectDto toDto (Project project) {
        ProjectDto dto = new ProjectDto(
                new IdDto(project.getId().getId()),
                project.getName(),
                project.getStart(),
                project.getCompanyId(),
                project.getCustomerId(),
                project.getCost()
        );
        dto .setDeveloperCount( project .getDeveloperCount() );
        return dto;
    }

    @Override
    public Project toEntity(ProjectDto dto) {
        Project project = new Project(
                new Id(dto.getId().getId()),
                dto.getName(),
                dto.getStart(),
                dto.getCompanyId(),
                dto.getCustomerId(),
                dto.getCost()
        );
        project .setDeveloperCount( dto .getDeveloperCount() );
        return project;
    }
}
