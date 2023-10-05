package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.service.ProjectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectProjectController {
    private ProjectService service;
    private Mapper<ProjectDto, Project> mapper;
    private Mapper<IdDto, Id> idMapper;

    public SelectProjectController(ProjectService service, Mapper<ProjectDto, Project> mapper, Mapper<IdDto, Id> idMapper) {
        this.service = service;
        this.mapper = mapper;
        this.idMapper = idMapper;
    }

    public List<ProjectDto> selectAll () {
        return service.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public ProjectDto select(IdDto id) {
        Project project = service .get(idMapper .toEntity(id));
        return mapper.toDto(project);
    }
}