package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.api.mapper.ProjectMapper;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.builder.ProjectBuilder;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.query.SelectProjectQuery;
import goit.dev.hw4.service.SelectEntityService;
import goit.dev.hw4.service.SelectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectProjectController {
    private SelectService service;
    private Mapper<ProjectDto, Project> mapper;

    public SelectProjectController(SelectService service, Mapper<ProjectDto, Project> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<ProjectDto> select () {
        return service.<Project>select(new SelectProjectQuery(), new ProjectBuilder()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    /* todo think
    public List <D> select () { // dto arg
        AbstractSelectQuery query = getQuery ()  // dto arg
        List <E> entities = service .select (query, builder);
        return entities .stream ()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    */
}