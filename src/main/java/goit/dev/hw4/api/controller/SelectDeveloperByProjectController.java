package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.service.DeveloperProjectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectDeveloperByProjectController {
    private DeveloperProjectService service;
    private Mapper<DeveloperDto, Developer> mapper;
    private Mapper<IdDto, Id> idMapper;

    public SelectDeveloperByProjectController(
            DeveloperProjectService service,
            Mapper<DeveloperDto, Developer> mapper,
            Mapper<IdDto, Id> idMapper
    ) {
        this.service = service;
        this.mapper = mapper;
        this .idMapper = idMapper;
    }

    public List<DeveloperDto> select (IdDto dto) {
        List<Developer> developers = service.getByProject(
                idMapper .toEntity(dto)
        );
        return developers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
