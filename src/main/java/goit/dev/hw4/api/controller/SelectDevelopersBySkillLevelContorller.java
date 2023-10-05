package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.service.DeveloperSkillService;

import java.util.List;
import java.util.stream.Collectors;

public class SelectDevelopersBySkillLevelContorller {
    private DeveloperSkillService service;
    private Mapper<DeveloperDto, Developer> mapper;

    public SelectDevelopersBySkillLevelContorller(
            DeveloperSkillService service,
            Mapper<DeveloperDto, Developer> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<DeveloperDto> select (FilterByStringDto dto) {
        List<Developer> developers = service.getBySkillLevel(dto.getValue());
        return developers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
