package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.SelectDeveloperController;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.ui.View;

import java.util.List;

public class GetAllDevelopersCommand implements Command {

    public static final String NAME = "developers";
    public static final String DESC = "Show all developers";

    private SelectDeveloperController controller;
    private View view;

    public GetAllDevelopersCommand(SelectDeveloperController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        List<DeveloperDto> developers = controller.selectAll();

        if (developers.isEmpty()){
            view.write("No developers");
            return;
        }

        developers.stream()
                .map(dto -> dto.toString())
                .forEach(view::write);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDesc() {
        return DESC;
    }
}
