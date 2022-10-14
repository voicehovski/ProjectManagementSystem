package goit.dev.hw4.api.mapper;

import goit.dev.hw4.model.Skill;
import goit.dev.hw4.model.dto.SkillDto;

public class SkillMapper implements Mapper<SkillDto, Skill> {
    @Override
    public SkillDto toDto(Skill entity) {
        return new SkillDto(entity.getId(), entity.getTrend(), entity.getLevel());
    }

    @Override
    public Skill toEntity(SkillDto dto) {
        return new Skill(dto.getId(), dto.getTrend(), dto.getLevel());
    }
}
