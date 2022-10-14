package goit.dev.hw4.api.controller;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.query.UpdateSkillQuery;
import goit.dev.hw4.service.UpdateEntityService;

public class UpdateSkillController {
    private DatabaseManagerConnector connector;

    public UpdateSkillController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public void update (SkillDto dto) {
        new UpdateEntityService(connector).update(new UpdateSkillQuery(
                statement -> {
                    statement.setString(1, dto.getTrend());
                    statement.setString(2, dto.getLevel());
                    statement.setLong(3, dto.getId());
                }
        ));
    }
}
