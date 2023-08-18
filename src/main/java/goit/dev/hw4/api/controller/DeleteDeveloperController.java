package goit.dev.hw4.api.controller;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.query.DeleteDeveloperQuery;
import goit.dev.hw4.query.DeleteProjectRelationByDeveloperIdQuery;
import goit.dev.hw4.query.DeleteSkillQuery;
import goit.dev.hw4.query.DeleteSkillRelationByDeveloperIdQuery;
import goit.dev.hw4.query.condition.FilterCondition;
import goit.dev.hw4.service.DeleteEntityService;
import goit.dev.hw4.service.DeleteService;

public class DeleteDeveloperController {

    private DeleteService service;

    public DeleteDeveloperController(DeleteService service) {
        this.service = service;
    }

    public int delete (IdDto dto) {
        FilterCondition condition = statement -> statement.setLong(1, dto.getId());

        int affected = service.delete(new DeleteDeveloperQuery(condition));
        service.delete(new DeleteSkillRelationByDeveloperIdQuery(condition));
        service.delete(new DeleteProjectRelationByDeveloperIdQuery(condition));

        return affected;
    }
}
