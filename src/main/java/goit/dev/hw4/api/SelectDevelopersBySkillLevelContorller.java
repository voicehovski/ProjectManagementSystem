package goit.dev.hw4.api;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.query.SelectDevelopersBySkillLevelQuery;
import goit.dev.hw4.query.SelectDevelopersBySkillTrendQuery;

import java.util.List;

public class SelectDevelopersBySkillLevelContorller {
    private SelectController<DeveloperDto, Developer> commonController;

    public SelectDevelopersBySkillLevelContorller(SelectController<DeveloperDto, Developer> commonController) {
        this.commonController = commonController;
    }

    public List<DeveloperDto> select (FilterByStringDto dto) {
        return commonController.select(
                new SelectDevelopersBySkillLevelQuery(statement -> statement.setString(1, dto.getValue()))
        );
    }
}
