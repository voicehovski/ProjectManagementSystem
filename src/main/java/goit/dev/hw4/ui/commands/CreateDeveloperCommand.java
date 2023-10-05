package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.InsertDeveloperController;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.ui.View;

import java.sql.Date;

public class CreateDeveloperCommand implements Command {

    public static final String NAME = "create developer";
    public static final String DESC = "Create new developer";

    private InsertDeveloperController controller;
    private View view;

    public CreateDeveloperCommand(InsertDeveloperController controller, View view) {
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
        view.write("Enter birth date");
        Date birthDate = Date.valueOf(view.read());
        view.write("Enter birthplace");
        String birthplace = view.read();
        view.write("Enter gender");
        String gender = view.read();
        view.write("Enter salary");
        int salary = Integer.parseInt(view.read());

        IdDto id = controller.insert(new DeveloperDto(name, birthDate, birthplace, gender, salary));
        view .write ( "New developer id: " + id.getId() );
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
