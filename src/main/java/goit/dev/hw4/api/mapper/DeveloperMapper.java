package goit.dev.hw4.api.mapper;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;

public class DeveloperMapper implements Mapper<DeveloperDto, Developer> {
    public DeveloperDto toDto (Developer developer) {
        return new DeveloperDto(
                developer.getId(),
                developer.getName(),
                developer.getBirthDate(),
                developer.getBirthPlace(),
                developer.getGender(),
                developer.getSalary()
        );
    }

    @Override
    public Developer toEntity(DeveloperDto dto) {
        return new Developer(
                dto.getId(),
                dto.getName(),
                dto.getBirthDate(),
                dto.getBirthPlace(),
                dto.getGender(),
                dto.getSalary()
        );
    }
}
