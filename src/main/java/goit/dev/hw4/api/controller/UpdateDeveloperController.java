package goit.dev.hw4.api.controller;

import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.query.UpdateDeveloperQuery;
import goit.dev.hw4.service.UpdateEntityService;

public class UpdateDeveloperController {
    private DatabaseManagerConnector connector;

    public UpdateDeveloperController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public void update (DeveloperDto developerDto) {
        new UpdateEntityService(connector).update(new UpdateDeveloperQuery(
            statement -> {
                statement.setString(1, developerDto.getName());
                statement.setDate(2, developerDto.getBirthDate());
                statement.setString(3, developerDto.getBirthPlace());
                statement.setString(4, developerDto.getGender());
                statement.setInt(5, developerDto.getSalary());

                statement.setLong(6, developerDto.getId());
            }
        ));
    }
}
