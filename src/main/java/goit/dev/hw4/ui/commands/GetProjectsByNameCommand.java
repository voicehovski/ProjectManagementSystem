package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.SelectProjectByNameController;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.ui.View;

import java.util.List;

public class GetProjectsByNameCommand implements Command {
    public static final String NAME = "projects(n)";
    public static final String DESC = "Show project with particular name";

    private SelectProjectByNameController controller;
    private View view;

    public GetProjectsByNameCommand(SelectProjectByNameController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        view.write("Enter project name");
        String projectName = view.read();
        List<ProjectDto> projects = controller.select(new FilterByStringDto(projectName));

        if (projects.isEmpty()){
            view.write("No project with such name");
            return;
        }

        projects.stream()
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
