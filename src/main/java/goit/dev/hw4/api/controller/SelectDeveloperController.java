package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.service.DeveloperService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectDeveloperController {

    private DeveloperService service;
    private Mapper<DeveloperDto, Developer> mapper;
    private Mapper<IdDto, Id> idMapper;

    public SelectDeveloperController(DeveloperService service, Mapper<DeveloperDto, Developer> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<DeveloperDto> selectAll () {
        return service. getAll() .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public DeveloperDto select (IdDto id) {
        Developer developer = service. get(idMapper .toEntity(id));
        return mapper.toDto(developer);
    }
}
