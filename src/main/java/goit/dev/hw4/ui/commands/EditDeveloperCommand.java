package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.UpdateDeveloperController;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.ui.View;

import java.sql.Date;


public class EditDeveloperCommand implements Command {

    public static final String NAME = "edit developer";
    public static final String DESC = "Edit existed developer";

    private UpdateDeveloperController controller;
    private View view;

    public EditDeveloperCommand(UpdateDeveloperController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        view.write("Enter id");
        long id = Long.parseLong(view.read());
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

        int affected = controller.update(new DeveloperDto(new IdDto(id), name, birthDate, birthplace, gender, salary));

        view .write ( "Edited developers: " + affected );
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
