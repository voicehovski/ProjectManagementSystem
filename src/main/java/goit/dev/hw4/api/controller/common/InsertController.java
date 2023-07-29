package goit.dev.hw4.api.controller.common;

import goit.dev.hw4.query.common.AbstractInsertQuery;
import goit.dev.hw4.query.common.Query;
import goit.dev.hw4.service.InsertService;

public class InsertController {
    InsertService service;

    public InsertController(InsertService service) {
        this.service = service;
    }

    public long insert (AbstractInsertQuery query) {
        return service.insert(query);
    }
}