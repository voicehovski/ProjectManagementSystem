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

public class SelectProjectController {
    private DatabaseManagerConnector connector;

    public SelectProjectController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public List<ProjectDto> select () {
        Mapper<ProjectDto, Project> mapper = new ProjectMapper();
        List<Project> projects = new SelectEntityService<Project>(connector).select(new SelectProjectQuery());
        return projects.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
