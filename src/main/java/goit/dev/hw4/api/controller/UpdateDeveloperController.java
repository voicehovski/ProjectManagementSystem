package goit.dev.hw4.api.controller;

import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.query.UpdateDeveloperQuery;
import goit.dev.hw4.service.UpdateService;

public class UpdateDeveloperController {    // todo implements UpdateController <DeveloperDto>
    private UpdateService service;

    public UpdateDeveloperController(UpdateService service) {
        this.service = service;
    }

    public int update (DeveloperDto developerDto) {
        return service.update(new UpdateDeveloperQuery(
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
