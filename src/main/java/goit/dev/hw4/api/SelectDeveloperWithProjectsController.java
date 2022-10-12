package goit.dev.hw4.api;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.dto.DeveloperWithProjectsDto;
import goit.dev.hw4.service.SelectService;

public class
SelectDeveloperWithProjectsController
extends SelectController <DeveloperWithProjectsDto, DeveloperWithProjects> {
    public SelectDeveloperWithProjectsController(
            SelectService<DeveloperWithProjects> service,
            Mapper<DeveloperWithProjectsDto, DeveloperWithProjects> mapper
    ) {
        super(service, mapper);
    }

    public List<DeveloperWithProjectsDto> select () {
        return commonController.select(new SelectDeveloperWithProjectsQuery());
    }
}
