package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.InsertProjectController;
import goit.dev.hw4.model.dto.ProjectDto;
import goit.dev.hw4.ui.View;

import java.sql.Date;

public class CreateProjectCommand implements Command {

    public static final String NAME = "create project";
    public static final String DESC = "Create new project";

    private InsertProjectController controller;
    private View view;

    public CreateProjectCommand(InsertProjectController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        view.write("Enter name");
        String name = view.read();
        view.write("Enter start date");
        Date startDate = Date.valueOf(view.read());
        view.write("Enter company id");
        Long companyId = Long.parseLong(view.read());
        view.write("Enter customer id");
        Long customerId = Long.parseLong(view.read());
        view.write("Enter cost");
        int cost = Integer.parseInt(view.read());

        long id = controller.insert(new ProjectDto(name, startDate, companyId, customerId, cost));
        view .write ( "New project id: " + id );
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
