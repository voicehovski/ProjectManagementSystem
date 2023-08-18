package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.builder.DeveloperWithProjectsBuilder;
import goit.dev.hw4.model.dto.DeveloperWithProjectsDto;
import goit.dev.hw4.query.SelectDeveloperWithProjectsQuery;
import goit.dev.hw4.service.SelectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectDeveloperWithProjectsController {
    private SelectService service;
    private Mapper<DeveloperWithProjectsDto, DeveloperWithProjects> mapper;

    public SelectDeveloperWithProjectsController(SelectService service, Mapper<DeveloperWithProjectsDto, DeveloperWithProjects> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<DeveloperWithProjectsDto> select () {
        return service.<DeveloperWithProjects>select(new SelectDeveloperWithProjectsQuery(), new DeveloperWithProjectsBuilder()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
