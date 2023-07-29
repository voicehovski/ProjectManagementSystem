package goit.dev.hw4.api.controller.common;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.query.common.AbstractSelectQuery;
import goit.dev.hw4.query.common.Query;
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

    public List<R> select (AbstractSelectQuery<E> query) {
        return service.select(query).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}