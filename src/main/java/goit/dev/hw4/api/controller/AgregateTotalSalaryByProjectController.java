package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.builder.AgregateNumberBuilder;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.NumberDto;
import goit.dev.hw4.query.TotalSalaryQuery;
import goit.dev.hw4.service.AgregateService;

public class AgregateTotalSalaryByProjectController {

    private AgregateService service;
    private Mapper<NumberDto, Integer> mapper;

    public AgregateTotalSalaryByProjectController(AgregateService service, Mapper<NumberDto, Integer> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public NumberDto select (IdDto idDto) {
        Integer agregateValue = service.get(
                new TotalSalaryQuery(statement -> statement.setLong(1,idDto.getId())),
                new AgregateNumberBuilder()
        );
        return mapper .toDto(agregateValue);
                //.stream()
                //.map(mapper::toDto)
                //.collect(Collectors.toList());
    }
}
