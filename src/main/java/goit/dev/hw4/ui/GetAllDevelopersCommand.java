package goit.dev.hw4.ui;

import goit.dev.hw4.api.controller.AgregateTotalSalaryByProjectController;
import goit.dev.hw4.api.controller.SelectAllDevelopersController;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;

import java.util.List;

public class GetAllDevelopersCommand implements Command {

    public static final String NAME = "all developers";

    private SelectAllDevelopersController controller;
    private View view;

    public GetAllDevelopersCommand(SelectAllDevelopersController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        List<DeveloperDto> developers = controller.select();

        if (developers.isEmpty()){
            view.write("No developers");
            return;
        }

        developers.stream()
                .map(dto -> dto.toString())
                .forEach(view::write);
    }
}
