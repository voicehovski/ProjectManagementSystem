package goit.dev.hw4.api.controller;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.query.DeleteSkillQuery;
import goit.dev.hw4.service.DeleteEntityService;

public class DeleteSkillController {
    private DatabaseManagerConnector connector;

    public DeleteSkillController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public void delete (IdDto dto) {
        new DeleteEntityService(connector).delete(new DeleteSkillQuery(
                statement -> statement.setLong(1, dto.getId())
        ));
    }
}
