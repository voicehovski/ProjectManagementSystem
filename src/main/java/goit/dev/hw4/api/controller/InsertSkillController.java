package goit.dev.hw4.api.controller;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.query.InsertSkillQuery;
import goit.dev.hw4.query.condition.FilterCondition;
import goit.dev.hw4.service.InsertEntityService;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertSkillController {
    private DatabaseManagerConnector connector;

    public InsertSkillController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public long insert (SkillDto dto) {
        return new InsertEntityService(connector).insert(new InsertSkillQuery(
                statement -> {
                    statement.setString(1, dto.getTrend());
                    statement.setString(2, dto.getLevel());
                }
        ));
    }
}
