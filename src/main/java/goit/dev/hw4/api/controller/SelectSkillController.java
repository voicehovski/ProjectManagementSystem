package goit.dev.hw4.api.controller;

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
    DatabaseManagerConnector connector;

    public SelectSkillController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public List<SkillDto> select () {
        Mapper<SkillDto, Skill> mapper = new SkillMapper();
        // Нужна промежуточная переменная skills, поскольку без неё стрим не понимает генерики
        List<Skill> skills =  new SelectEntityService<>(connector).select(new SelectSkillQuery());
        return skills.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
