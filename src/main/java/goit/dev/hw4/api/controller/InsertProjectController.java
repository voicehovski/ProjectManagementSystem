package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.mapper.Mapper;
import goit.dev.hw4.api.mapper.ProjectMapper;
import goit.dev.hw4.config.DatabaseManagerConnector;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.query.InsertProjectQuery;
import goit.dev.hw4.service.InsertEntityService;

public class InsertProjectController {
    private DatabaseManagerConnector connector;

    public InsertProjectController(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public long insert (ProjectDto dto) {
        Mapper mapper = new ProjectMapper();
        return new InsertEntityService(connector).insert(new InsertProjectQuery(
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
