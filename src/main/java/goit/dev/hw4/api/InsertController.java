package goit.dev.hw4.api;

import goit.dev.hw4.query.common.Query;
import goit.dev.hw4.service.InsertService;

public class InsertController {
    InsertService service;

    public InsertController(InsertService service) {
        this.service = service;
    }

    public long insert (Query query) {
        return service.insert(query);
    }
}