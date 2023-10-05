package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.ProjectMapper;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.service.ProjectService;

public class InsertProjectController {

    private ProjectService service;
    private ProjectMapper mapper;

    public InsertProjectController(ProjectService service, ProjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public Id insert (ProjectDto dto) {
        return service.add(mapper.toEntity(dto));
    }
}
