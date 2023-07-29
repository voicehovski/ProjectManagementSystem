package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.api.mapper.SkillMapper;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.Skill;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.query.SelectSkillQuery;
import goit.dev.hw4.service.SelectEntityService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectSkillController {
    private SelectController <SkillDto, Skill> commonController;

    public SelectSkillController ( SelectController <SkillDto, Skill> commonController ) {
        this .commonController = commonController;
    }

    public List<SkillDto> select () {
        return commonController .select(new SelectSkillQuery());
    }
}
