package goit.dev.hw4.api.mapper;

import goit.dev.hw4.model.dto.NumberDto;

public class NumberMapper implements Mapper <NumberDto, Integer> {
    @Override
    public NumberDto toDto(Integer entity) {
        return new NumberDto(entity);
    }

    @Override
    public Integer toEntity(NumberDto dto) {
        return dto.getValue();
    }
}
