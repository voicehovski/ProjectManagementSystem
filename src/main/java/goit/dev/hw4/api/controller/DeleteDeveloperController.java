package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.service.DeveloperService;

public class DeleteDeveloperController {

    private DeveloperService service;
    private Mapper<IdDto, Id> mapper;

    public DeleteDeveloperController(DeveloperService service, Mapper<IdDto, Id> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public int delete (IdDto dto) {
        return service .remove(mapper.toEntity(dto));
    }
}
