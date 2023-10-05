package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.service.DeveloperSkillService;

import java.util.List;
import java.util.stream.Collectors;

// Очень похож на BySkillLevel
public class SelectDevelopersBySkillTrendContorller {
    private DeveloperSkillService service;
    private Mapper<DeveloperDto, Developer> mapper;

    public SelectDevelopersBySkillTrendContorller(
            DeveloperSkillService service,
            Mapper<DeveloperDto, Developer> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<DeveloperDto> select (FilterByStringDto dto) {
        List<Developer> developers = service.getBySkillTrend(dto.getValue());
        return developers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
