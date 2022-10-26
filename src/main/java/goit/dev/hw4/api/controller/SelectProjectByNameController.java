package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.api.mapper.ProjectMapper;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.Project;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.query.SelectProjectByProjectNameQuery;
import goit.dev.hw4.service.SelectEntityService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectProjectByNameController {

    private DatabaseManagerConnector connector;

    public SelectProjectByNameController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public List<ProjectDto> select (FilterByStringDto dto) {
        Mapper<ProjectDto, Project> mapper = new ProjectMapper();
        List<Project> projects = new SelectEntityService<Project>(connector)
                .select(new SelectProjectByProjectNameQuery((statement)->statement.setString(1, dto.getValue())));
        return projects.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
