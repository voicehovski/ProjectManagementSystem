package goit.dev.hw4.api.mapper;

import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.dto.IdDto;

public class IdMapper implements Mapper<IdDto, Id> {
    @Override
    public IdDto toDto(Id entity) {
        return new IdDto(entity.getId());
    }

    @Override
    public Id toEntity(IdDto dto) {
        return new Id(dto.getId());
    }
}
