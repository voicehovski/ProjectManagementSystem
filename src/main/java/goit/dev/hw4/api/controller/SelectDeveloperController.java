package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.builder.DeveloperBuilder;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.query.SelectDeveloperQuery;
import goit.dev.hw4.query.SelectDeveloperQuery;
import goit.dev.hw4.service.SelectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectDeveloperController {

    private SelectService service;
    private Mapper<DeveloperDto, Developer> mapper;

    public SelectDeveloperController(SelectService service, Mapper<DeveloperDto, Developer> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<DeveloperDto> select () {
        return service.<Developer>select(new SelectDeveloperQuery(), new DeveloperBuilder()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
