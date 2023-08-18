package goit.dev.hw4.api.controller;

import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.query.UpdateSkillQuery;
import goit.dev.hw4.service.UpdateService;

public class UpdateSkillController {
    private UpdateService service;

    public UpdateSkillController(UpdateService service) {
        this.service = service;
    }

    public int update (SkillDto dto) {
        return service.update(new UpdateSkillQuery(
                statement -> {
                    statement.setString(1, dto.getTrend());
                    statement.setString(2, dto.getLevel());
                    statement.setLong(3, dto.getId());
                }
        ));
    }
}
