package goit.dev.hw4.api;

import goit.dev.hw4.query.Query;
import goit.dev.hw4.service.InsertService;
import goit.dev.hw4.service.SelectService;

import java.util.List;
import java.util.stream.Collectors;

public class InsertController {
    InsertService service;

    public InsertController(InsertService service) {
        this.service = service;
    }

    public long insert (Query query) {
        return service.insert(query);
    }
}