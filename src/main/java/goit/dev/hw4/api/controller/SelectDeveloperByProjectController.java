package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.NumberDto;
import goit.dev.hw4.query.SelectDeveloperByProjectQuery;
import goit.dev.hw4.query.SelectDeveloperBySkillLevelQuery;

import java.util.List;

public class SelectDeveloperByProjectController {
    private SelectController<DeveloperDto, Developer> commonController;

    public SelectDeveloperByProjectController(SelectController<DeveloperDto, Developer> commonController) {
        this.commonController = commonController;
    }

    public List<DeveloperDto> select (IdDto dto) {
        return commonController.select(
                new SelectDeveloperByProjectQuery(statement -> statement.setLong(1, dto.getId()))
        );
    }
}
