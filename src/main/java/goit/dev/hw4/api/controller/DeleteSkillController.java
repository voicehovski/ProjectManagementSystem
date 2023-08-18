package goit.dev.hw4.api.controller;

import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.query.DeleteSkillQuery;
import goit.dev.hw4.service.DeleteService;

public class DeleteSkillController {

    private DeleteService service;

    public DeleteSkillController(DeleteService service) {
        this.service = service;
    }

    public int delete (IdDto dto) {
        return service.delete(new DeleteSkillQuery(
                statement -> statement.setLong(1, dto.getId())
        ));
    }
}
