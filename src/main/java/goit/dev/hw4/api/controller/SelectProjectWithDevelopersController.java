package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.ProjectWithDevelopers;
import goit.dev.hw4.model.builder.ProjectWithDevelopersBuilder;
import goit.dev.hw4.model.dto.ProjectWithDevelopersDto;
import goit.dev.hw4.query.SelectProjectWithDevelopersQuery;
import goit.dev.hw4.service.SelectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectProjectWithDevelopersController {
    private SelectService service;
    private Mapper<ProjectWithDevelopersDto, ProjectWithDevelopers> mapper;

    public SelectProjectWithDevelopersController(SelectService service, Mapper<ProjectWithDevelopersDto, ProjectWithDevelopers> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<ProjectWithDevelopersDto> select () {
        return service.<ProjectWithDevelopers>select(new SelectProjectWithDevelopersQuery(), new ProjectWithDevelopersBuilder()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
