package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.service.DeveloperService;

public class UpdateDeveloperController {
    private DeveloperService service;
    private Mapper<DeveloperDto, Developer> mapper;

    public UpdateDeveloperController(DeveloperService service, Mapper<DeveloperDto, Developer> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public int update (DeveloperDto developerDto) {
        return service.put(mapper.toEntity(developerDto));
    }
}
