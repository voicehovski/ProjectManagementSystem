package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.SelectDeveloperByProjectController;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.ui.View;

import java.util.List;

public class GetDeveloperByProjectCommand implements Command {
    public static final String NAME = "developers(p)";
    public static final String DESC = "Show developers on particular project";

    private SelectDeveloperByProjectController controller;
    private View view;

    public GetDeveloperByProjectCommand(SelectDeveloperByProjectController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        view.write("Enter project id");
        String id = view.read();
        List<DeveloperDto> developers = controller.select(new IdDto(Long.parseLong(id)));

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
