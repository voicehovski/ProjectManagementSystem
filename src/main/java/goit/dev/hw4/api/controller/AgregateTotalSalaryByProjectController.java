package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.controller.common.AgregateController;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.NumberDto;
import goit.dev.hw4.query.TotalSalaryQuery;

public class AgregateTotalSalaryByProjectController {
    private AgregateController<NumberDto, Integer> commonController;

    public AgregateTotalSalaryByProjectController(AgregateController commonController) {
        this.commonController = commonController;
    }

    public NumberDto select (IdDto idDto) {
        return commonController.select(
                new TotalSalaryQuery(statement -> statement.setLong(1,idDto.getId()))
        );
    }
}
