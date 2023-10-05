package goit.dev.hw4.api.mapper;

import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.Skill;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.SkillDto;

public class SkillMapper implements Mapper<SkillDto, Skill> {
    @Override
    public SkillDto toDto(Skill entity) {
        return new SkillDto(new IdDto(entity.getId().getId()), entity.getTrend(), entity.getLevel());
    }

    @Override
    public Skill toEntity(SkillDto dto) {
        return new Skill(new Id(dto.getId().getId()), dto.getTrend(), dto.getLevel());
    }
}
