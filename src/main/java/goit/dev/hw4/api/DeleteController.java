package goit.dev.hw4.api;

import goit.dev.hw4.query.Query;
import goit.dev.hw4.service.DeleteService;
import goit.dev.hw4.service.InsertService;

public class DeleteController {
    DeleteService service;

    public DeleteController(DeleteService service) {
        this.service = service;
    }

    public void delete (Query query) {
        service.delete(query);
    }
}