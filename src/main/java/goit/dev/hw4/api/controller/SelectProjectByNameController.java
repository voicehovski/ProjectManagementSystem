package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.api.mapper.ProjectMapper;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.builder.ProjectBuilder;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.query.SelectProjectByProjectNameQuery;
import goit.dev.hw4.query.SelectProjectQuery;
import goit.dev.hw4.service.SelectEntityService;
import goit.dev.hw4.service.SelectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectProjectByNameController {
    private SelectService service;
    private Mapper<ProjectDto, Project> mapper;

    public SelectProjectByNameController(SelectService service, Mapper<ProjectDto, Project> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<ProjectDto> select (FilterByStringDto dto) {
        List<Project> projects = service.<Project>select(
            new SelectProjectByProjectNameQuery(
                    (statement)->statement.setString(1, dto.getValue())
            ),
            new ProjectBuilder());
        return projects.stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }
}
