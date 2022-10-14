package goit.dev.hw4.api.mapper;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.DeveloperWithProjectsDto;
import goit.dev.hw4.model.dto.ProjectDto;

public class DeveloperWithProjectsMapper implements Mapper<DeveloperWithProjectsDto, DeveloperWithProjects> {
    private final Mapper<DeveloperDto, Developer> developerMapper;
    private final Mapper<ProjectDto, Project> projectMapper;

    public DeveloperWithProjectsMapper(Mapper<DeveloperDto, Developer> developerMapper, Mapper<ProjectDto, Project> projectMapper) {
        this.developerMapper = developerMapper;
        this.projectMapper = projectMapper;
    }

    @Override
    public DeveloperWithProjectsDto toDto (DeveloperWithProjects developer) {
        DeveloperDto developerDto = developerMapper.toDto(developer.getDeveloper());
        DeveloperWithProjectsDto dto = new DeveloperWithProjectsDto(developerDto);
        developer.getProjects().stream()
                .map(project -> projectMapper.toDto(project))
                .forEach(dto::addProject);
        return dto;
    }

    @Override
    public DeveloperWithProjects toEntity(DeveloperWithProjectsDto dto) {
            Developer developer = developerMapper.toEntity(dto.getDeveloper());
            DeveloperWithProjects entity = new DeveloperWithProjects(developer);
            dto.getProjectList().stream()
                    //.map(projectDto -> projectMapper::toEntity)   // Почему не получается?
                    .map(projectDto ->projectMapper.toEntity(projectDto))
                    .forEach(entity::addProject);
            return entity;
    }
}
