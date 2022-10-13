package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.model.ProjectWithDevelopers;
import goit.dev.hw4.model.dto.DeveloperWithProjectsDto;
import goit.dev.hw4.model.dto.ProjectWithDevelopersDto;
import goit.dev.hw4.query.SelectDeveloperWithProjectsQuery;
import goit.dev.hw4.query.SelectProjectWithDevelopersQuery;

import java.util.List;

public class SelectProjectWithDevelopersController {
    private SelectController<ProjectWithDevelopersDto, ProjectWithDevelopers> commonController;

    public SelectProjectWithDevelopersController(SelectController commonController) {
        this.commonController = commonController;
    }

    public List<ProjectWithDevelopersDto> select () {
        return commonController.select(new SelectProjectWithDevelopersQuery());
    }
}
