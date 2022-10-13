package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.query.SelectDeveloperBySkillLevelQuery;

import java.util.List;

public class SelectDevelopersBySkillLevelContorller {
    private SelectController<DeveloperDto, Developer> commonController;

    public SelectDevelopersBySkillLevelContorller(SelectController<DeveloperDto, Developer> commonController) {
        this.commonController = commonController;
    }

    public List<DeveloperDto> select (FilterByStringDto dto) {
        return commonController.select(
                new SelectDeveloperBySkillLevelQuery(statement -> statement.setString(1, dto.getValue()))
        );
    }
}
