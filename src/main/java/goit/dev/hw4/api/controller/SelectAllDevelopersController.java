package goit.dev.hw4.api.controller;

import goit.dev.hw4.api.controller.common.SelectController;
import goit.dev.hw4.model.Developer;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.query.SelectDeveloperQuery;

import java.util.List;

public class SelectAllDevelopersController {
    /*
    * Все контроллеры выборки содержат общий код. Можно не обращать внимания - его не так много,
    * но хочется решить эту проблему.
    * Можно наследовать класс от SelectController, но агрегация выглядит достатоочно компактно и
    * более логично, хотя и несколько усложняет структуру.*/
    private SelectController commonController;
    public SelectAllDevelopersController(SelectController<DeveloperDto, Developer> commonController) {
        this .commonController = commonController;
    }

    public List<DeveloperDto> select () {
        return commonController.select(new SelectDeveloperQuery());
    }
}
