package goit.dev.hw4.api.controller;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.query.InsertDeveloperQuery;
import goit.dev.hw4.service.InsertEntityService;

import java.sql.Date;

public class InsertDeveloperController {
    private DatabaseManagerConnector connector;

    public InsertDeveloperController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public long insert (DeveloperDto developerDto) {
        return new InsertEntityService(connector).insert(
            new InsertDeveloperQuery(statement -> {
                statement.setString(1,developerDto.getName());
                statement.setDate(2, developerDto.getBirthDate());
                statement.setString(3,developerDto.getBirthPlace());
                statement.setString(4,developerDto.getGender());
                statement.setInt(5,developerDto.getSalary());
            })
        );
    }
}
