package goit.dev.hw4.api.controller;

import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.query.InsertSkillQuery;
import goit.dev.hw4.service.InsertService;

public class InsertSkillController {

    private InsertService service;

    public InsertSkillController(InsertService service) {
        this.service = service;
    }

    public long insert (SkillDto dto) {
        return service.insert(new InsertSkillQuery(
                statement -> {
                    statement.setString(1, dto.getTrend());
                    statement.setString(2, dto.getLevel());
                }
        ));
    }
}
