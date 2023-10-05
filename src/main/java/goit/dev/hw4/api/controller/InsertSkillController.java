package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Skill;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.service.SkillService;

public class InsertSkillController {

    private SkillService service;
    private Mapper<SkillDto, Skill> mapper;
    private Mapper<IdDto, Id> idMapper;

    public InsertSkillController(SkillService service, Mapper<SkillDto, Skill> mapper, Mapper<IdDto, Id> idMapper) {
        this.service = service;
        this.mapper = mapper;
        this.idMapper = idMapper;
    }

    public IdDto insert (SkillDto skillDto) {
        Id id = service.add(mapper.toEntity(skillDto));
        return idMapper.toDto(id);
    }
}
