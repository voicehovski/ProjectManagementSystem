package goit.dev.hw4.api;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.query.condition.FilterCondition;
import goit.dev.hw4.service.SelectService;

import java.util.List;

public class SelectDeveloperController extends SelectController<DeveloperDto, Developer> {
    public SelectDeveloperController(SelectService<Developer> service, Mapper<DeveloperDto, Developer> mapper) {
        super(service, mapper);
    }
}
