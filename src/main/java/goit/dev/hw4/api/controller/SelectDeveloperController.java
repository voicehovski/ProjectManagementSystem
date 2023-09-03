package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.builder.DeveloperBuilder;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.query.SelectDeveloperQuery;
import goit.dev.hw4.query.SelectDeveloperQuery;
import goit.dev.hw4.repository.DeveloperRepository;
import goit.dev.hw4.service.SelectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectDeveloperController {

    private DeveloperRepository repository;
    private Mapper<DeveloperDto, Developer> mapper;

    public SelectDeveloperController(DeveloperRepository repository, Mapper<DeveloperDto, Developer> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DeveloperDto> select () {
        return repository. getAll(new SelectDeveloperQuery(), new DeveloperBuilder()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
