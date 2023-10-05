package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.service.ProjectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectProjectByNameController {
    private ProjectService service;
    private Mapper<ProjectDto, Project> mapper;

    public SelectProjectByNameController(ProjectService service, Mapper<ProjectDto, Project> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<ProjectDto> select (FilterByStringDto dto) {
        List<Project> projects = service.getByName(dto.getValue());
        return projects.stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }
}
