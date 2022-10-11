package goit.dev.hw4.api;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.query.Query;
import goit.dev.hw4.service.AgregateService;
import goit.dev.hw4.service.SelectService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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