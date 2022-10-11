package goit.dev.hw4.api;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.query.Query;
import goit.dev.hw4.service.AgregateService;

public class AgregateController <R, E> { // RESULT_DTO, ENTITY
    AgregateService<E> service;
    Mapper<R, E> mapper;

    public AgregateController(AgregateService<E> service, Mapper<R, E> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public R select(Query<E> query) {
        return mapper.toDto(service.get(query));
    }
}