package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.dto.DeveloperWithProjectsDto;
import goit.dev.hw4.service.DeveloperProjectService;

import java.util.Collections;
import java.util.List;

public class SelectDeveloperWithProjectsController {
    private DeveloperProjectService service;
    private Mapper<DeveloperWithProjectsDto, DeveloperWithProjects> mapper;

    public SelectDeveloperWithProjectsController(DeveloperProjectService service, Mapper<DeveloperWithProjectsDto, DeveloperWithProjects> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<DeveloperWithProjectsDto> selectAll () {
        // todo Realize
        return Collections.emptyList();
    }
}
