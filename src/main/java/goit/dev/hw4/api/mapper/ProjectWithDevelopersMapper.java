package goit.dev.hw4.api.mapper;

import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.ProjectWithDevelopers;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.model.dto.ProjectWithDevelopersDto;

public class ProjectWithDevelopersMapper implements Mapper<ProjectWithDevelopersDto, ProjectWithDevelopers> {

    private final DeveloperMapper developerMapper;
    private final ProjectMapper projectMapper;

    public ProjectWithDevelopersMapper(DeveloperMapper developerMapper, ProjectMapper projectMapper) {
        this.developerMapper = developerMapper;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectWithDevelopersDto toDto(ProjectWithDevelopers entity) {
        ProjectDto projectDto = projectMapper.toDto(entity.getProject());
        ProjectWithDevelopersDto dto = new ProjectWithDevelopersDto(projectDto);
        entity.getDevelopers().stream()
                .map(developer -> developerMapper.toDto(developer))
                .forEach(dto::addDeveloper);
        return dto;
    }

    @Override
    public ProjectWithDevelopers toEntity(ProjectWithDevelopersDto dto) {
        Project project = projectMapper.toEntity(dto.getProject());
        ProjectWithDevelopers entity = new ProjectWithDevelopers(project);
        dto.getDeveloperList().stream()
                .map(developerDto -> developerMapper.toEntity(developerDto))
                .forEach(entity::addDeveloper);
        return entity;
    }
}
