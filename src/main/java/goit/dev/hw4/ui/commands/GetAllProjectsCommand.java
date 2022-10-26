package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.SelectProjectController;
import goit.dev.hw4.api.controller.SelectSkillController;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.ui.View;

import java.util.List;

public class GetAllProjectsCommand implements Command {
    public static final String NAME = "projects";
    public static final String DESC = "Show all projects";

    private SelectProjectController controller;
    private View view;

    public GetAllProjectsCommand(SelectProjectController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        List<ProjectDto> projects = controller.select();

        if (projects.isEmpty()){
            view.write("No projects");
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
