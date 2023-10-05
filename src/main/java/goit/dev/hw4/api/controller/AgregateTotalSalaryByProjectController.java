package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.NumberDto;
import goit.dev.hw4.service.DeveloperProjectService;

public class AgregateTotalSalaryByProjectController {

    private DeveloperProjectService service;
    private Mapper<IdDto, Id> mapper;

    public AgregateTotalSalaryByProjectController(DeveloperProjectService service, Mapper<IdDto, Id> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public NumberDto select (IdDto idDto) {
        Integer agregateValue = service.getTotalSalaryByProject(
                mapper .toEntity(idDto)
        );
        return new NumberDto(agregateValue);
    }
}
