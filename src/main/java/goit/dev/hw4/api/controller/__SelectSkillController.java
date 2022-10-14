package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.model.Skill;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.query.SelectSkillQuery;

import java.util.List;

public class __SelectSkillController {
    private SelectController commonController;

    public __SelectSkillController(SelectController<SkillDto, Skill> commonController) {
        this.commonController = commonController;
    }

    public List<SkillDto> select () {
        return commonController.select(new SelectSkillQuery());
    }
}
