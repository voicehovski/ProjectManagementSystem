package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Skill;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.service.SkillService;

public class UpdateSkillController {
    private SkillService service;
    private Mapper<SkillDto, Skill> mapper;

    public UpdateSkillController(SkillService service, Mapper<SkillDto, Skill> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public int update (SkillDto dto) {
        return service .put ( mapper. toEntity(dto) );
    }
}
