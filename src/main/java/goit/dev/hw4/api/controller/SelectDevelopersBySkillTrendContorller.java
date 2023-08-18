package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.builder.DeveloperBuilder;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.query.SelectDeveloperBySkillTrendQuery;
import goit.dev.hw4.service.SelectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectDevelopersBySkillTrendContorller {
    private SelectService service;
    private Mapper<DeveloperDto, Developer> mapper;

    public SelectDevelopersBySkillTrendContorller(SelectService service, Mapper<DeveloperDto, Developer> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<DeveloperDto> select (FilterByStringDto dto) {
        List<Developer> developers = service.<Developer>select(
                new SelectDeveloperBySkillTrendQuery(
                        statement -> statement.setString(1, dto.getValue())
                ),
                new DeveloperBuilder());
        return developers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
