package goit.dev.hw4.api.controller.common;

import goit.dev.hw4.query.common.AbstractDeleteQuery;
import goit.dev.hw4.query.common.Query;
import goit.dev.hw4.service.DeleteService;

// todo Нужен ли этот контроллер? insert?
public class DeleteController {
    DeleteService service;

    public DeleteController(DeleteService service) {
        this.service = service;
    }

    public void delete (AbstractDeleteQuery query) {
        service.delete(query);
    }
}