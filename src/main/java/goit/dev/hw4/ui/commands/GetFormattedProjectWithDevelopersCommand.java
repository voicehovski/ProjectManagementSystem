package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.SelectProjectWithDevelopersController;
import goit.dev.hw4.model.dto.ProjectWithDevelopersDto;
import goit.dev.hw4.ui.View;

import java.sql.Date;
import java.util.List;

public class GetFormattedProjectWithDevelopersCommand implements Command {

    public static final String NAME = "projects+d";
    public static final String DESC = "Show projects short info with developers count";

    private SelectProjectWithDevelopersController controller;
    private View view;

    public GetFormattedProjectWithDevelopersCommand(SelectProjectWithDevelopersController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        List<ProjectWithDevelopersDto> projectWithDevelopers = controller.select();

        if (projectWithDevelopers.isEmpty()){
            view.write("No projects");
            return;
        }

        projectWithDevelopers.stream()
                .map(this::format)
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

    private String format (ProjectWithDevelopersDto dto) {
        Date date = dto.getProject().getStart();
        String name = dto.getProject().getName();
        int developersCount = dto.getDeveloperList().size();
        return String.format("%s - %s - %d", date, name, developersCount);
    }
}