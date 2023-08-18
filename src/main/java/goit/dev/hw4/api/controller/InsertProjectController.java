package goit.dev.hw4.api.controller;

import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.query.InsertProjectQuery;
import goit.dev.hw4.service.InsertService;

public class InsertProjectController {

    private InsertService service;

    public InsertProjectController(InsertService service) {
        this.service = service;
    }

    public long insert (ProjectDto dto) {
        return service.insert(new InsertProjectQuery(
                statement -> {
                    statement.setString(1, dto.getName());
                    statement.setDate(2, dto.getStart());
                    statement.setLong(3, dto.getCompanyId());
                    statement.setLong(4, dto.getCustomerId());
                    statement.setInt(5, dto.getCost());
                }
        ));
    }
}
