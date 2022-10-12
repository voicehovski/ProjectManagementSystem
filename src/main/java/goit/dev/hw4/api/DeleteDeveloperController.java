package goit.dev.hw4.api;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.query.DeleteDeveloperQuery;
import goit.dev.hw4.query.DeleteProjectRelationQuery;
import goit.dev.hw4.query.DeleteSkillRelationQuery;
import goit.dev.hw4.query.condition.FilterCondition;
import goit.dev.hw4.service.DeleteEntityService;
import goit.dev.hw4.service.DeleteService;

public class DeleteDeveloperController {
    private DatabaseManagerConnector connector;

    public DeleteDeveloperController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public void delete (IdDto idDto) {
        DeleteService deleteDeveloperService = new DeleteEntityService(connector);
        FilterCondition condition = statement -> statement.setLong(1, idDto.getId());

        deleteDeveloperService.delete(new DeleteDeveloperQuery(condition));
        deleteDeveloperService.delete(new DeleteSkillRelationQuery(condition));
        deleteDeveloperService.delete(new DeleteProjectRelationQuery(condition));
    }
}