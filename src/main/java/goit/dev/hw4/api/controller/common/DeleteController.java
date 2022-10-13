package goit.dev.hw4.api.controller.common;

import goit.dev.hw4.query.common.Query;
import goit.dev.hw4.service.DeleteService;

public class DeleteController {
    DeleteService service;

    public DeleteController(DeleteService service) {
        this.service = service;
    }

    public void delete (Query query) {
        service.delete(query);
    }
}