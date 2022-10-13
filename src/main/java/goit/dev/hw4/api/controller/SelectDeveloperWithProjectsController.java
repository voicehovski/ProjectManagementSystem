package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.model.DeveloperWithProjects;
import goit.dev.hw4.model.dto.DeveloperWithProjectsDto;
import goit.dev.hw4.query.SelectDeveloperWithProjectsQuery;

import java.util.List;

public class SelectDeveloperWithProjectsController {
    private SelectController<DeveloperWithProjectsDto, DeveloperWithProjects> commonController;

    public SelectDeveloperWithProjectsController(SelectController commonController) {
        this.commonController = commonController;
    }

    public List<DeveloperWithProjectsDto> select () {
        return commonController.select(new SelectDeveloperWithProjectsQuery());
    }
}
