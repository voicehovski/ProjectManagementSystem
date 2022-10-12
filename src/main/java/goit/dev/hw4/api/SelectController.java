package goit.dev.hw4.api;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.query.Query;
import goit.dev.hw4.query.SelectDeveloperQuery;
import goit.dev.hw4.query.SelectDevelopersBySkillTrendQuery;
import goit.dev.hw4.query.condition.FilterCondition;
import goit.dev.hw4.service.SelectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectController <R, E> { // RESULT_DTO, ENTITY
    SelectService<E> service;
    Mapper<R, E> mapper;

    public SelectController(SelectService<E> service, Mapper<R, E> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<R> select (Query<E> query) {
        return service.select(query).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}