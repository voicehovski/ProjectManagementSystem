package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.query.SelectDeveloperBySkillTrendQuery;

import java.util.List;

public class SelectDevelopersBySkillTrendContorller {
    private SelectController<DeveloperDto, Developer> commonController;
    public SelectDevelopersBySkillTrendContorller(SelectController commonController) {
        this .commonController = commonController;
    }
    public List<DeveloperDto> select (FilterByStringDto dto) {
        return commonController.select(
                new SelectDeveloperBySkillTrendQuery(statement -> statement.setString(1, dto.getValue()))
        );
    }
}
