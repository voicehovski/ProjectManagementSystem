package goit.dev.hw4.api.mapper;

import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.Id;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.IdDto;

public class DeveloperMapper implements Mapper<DeveloperDto, Developer> {
    public DeveloperDto toDto (Developer developer) {
        return new DeveloperDto(
                new IdDto(developer.getId().getId()),
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
                new Id(dto.getId().getId()),
                dto.getName(),
                dto.getBirthDate(),
                dto.getBirthPlace(),
                dto.getGender(),
                dto.getSalary()
        );
    }
}
