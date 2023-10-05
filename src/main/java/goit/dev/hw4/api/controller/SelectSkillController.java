package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Skill;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.service.SkillService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectSkillController {

    private SkillService service;
    private Mapper<SkillDto, Skill> mapper;
    private Mapper<IdDto, Id> idMapper;

    public SelectSkillController(SkillService service, Mapper<SkillDto, Skill> mapper, Mapper<IdDto, Id> idMapper) {
        this.service = service;
        this.mapper = mapper;
        this.idMapper = idMapper;
    }

    public List<SkillDto> selectAll () {
        return service.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public Skill select (IdDto skillId) {
        return service .get(idMapper.toEntity(skillId));
    }
}
