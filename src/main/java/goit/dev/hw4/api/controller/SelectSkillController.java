package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Skill;
import goit.dev.hw4.model.builder.SkillBuilder;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.query.SelectSkillQuery;
import goit.dev.hw4.service.SelectService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectSkillController {

    private SelectService service;
    private Mapper<SkillDto, Skill> mapper;

    public SelectSkillController(SelectService service, Mapper<SkillDto, Skill> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<SkillDto> select () {
        return service.select(new SelectSkillQuery(), new SkillBuilder()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
