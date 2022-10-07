package goit.dev.hw4.api;

import goit.dev.hw4.api.mapper.Mapper;
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

    public List<R> select (FilterCondition filter) {
        return entityToDtoList(service.select(filter));
    }

    public List<R> select(){
        return entityToDtoList(service.select());
    }

    private List<R> entityToDtoList (List<E> entityList) {
        return entityList.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}