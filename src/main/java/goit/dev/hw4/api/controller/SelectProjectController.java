package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.api.mapper.ProjectMapper;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.query.SelectProjectQuery;
import goit.dev.hw4.service.SelectEntityService;

import java.util.List;
import java.util.stream.Collectors;

// Класс может быть реализован с использованием SelectController. Текущая реализация служит для примера
// и поясняет некоторые особенности использования generics
public class SelectProjectController {
    private DatabaseManagerConnector connector;

    public SelectProjectController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public List<ProjectDto> select () {
        Mapper<ProjectDto, Project> mapper = new ProjectMapper();
        // Нужна промежуточная переменная projects, поскольку без неё стрим не понимает генерики.
        // Также если не заполнен <> в new, оно почемуто не подставляет Project из объявления переменой,
        // но подставляет Object, так что метод select получает не подходящий аргумент.
        // Без <> не подчеркивает красным, но выдаёт предупреждение
        List<Project> projects = new SelectEntityService<Project>(connector).select(new SelectProjectQuery());
        return projects.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
/*
class SelectController<D,E> {
    private Mapper<D, E> mapper;
    private EntityBuilder <E> builder;
    private SelectEntityService <E> service;
    public SelectController () {

    }

    public List <D> select () { // dto arg
        AbstractSelectQuery query = getQuery ()  // dto arg
        List <E> entities = service .select (query, builder);
        return entities .stream ()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
*/