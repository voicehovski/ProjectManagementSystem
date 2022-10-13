package goit.dev.hw4.ui;

import goit.dev.hw4.api.controller.SelectAllDevelopersController;
import goit.dev.hw4.api.controller.SelectProjectWithDevelopersController;
import goit.dev.hw4.model.ProjectWithDevelopers;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.ProjectWithDevelopersDto;

import java.sql.Date;
import java.util.List;

public class GetFormattedProjectWithDevelopersCommand implements Command {

    public static final String NAME = "all projects(d)";

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

    private String format (ProjectWithDevelopersDto dto) {
        // date, name, dev count
        Date date = dto.getProject().getStart();
        String name = dto.getProject().getName();
        int developersCount = dto.getDeveloperList().size();
        return String.format("%s - %s - %d", date, name, developersCount);
    }
}