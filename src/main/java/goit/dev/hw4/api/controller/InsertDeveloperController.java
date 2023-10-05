package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.service.DeveloperService;

import java.sql.Date;

public class InsertDeveloperController {
    private DeveloperService service;
    private Mapper<DeveloperDto, Developer> mapper;
    private Mapper<IdDto, Id> idMapper;

    public InsertDeveloperController(DeveloperService service, Mapper<DeveloperDto, Developer> mapper, Mapper<IdDto, Id> idMapper) {
        this.service = service;
        this.mapper = mapper;
        this.idMapper = idMapper;
    }

    public IdDto insert (DeveloperDto developerDto) {
        Id id = service.add(mapper.toEntity(developerDto));
        return idMapper .toDto(id);
    }
}
