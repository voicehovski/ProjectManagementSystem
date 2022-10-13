package goit.dev.hw4.ui;

import goit.dev.hw4.api.controller.UpdateDeveloperController;
import goit.dev.hw4.model.dto.DeveloperDto;

import java.sql.Date;


public class EditDeveloperCommand implements Command {

    public static final String NAME = "edit developer";

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

        controller.update(new DeveloperDto(id, name, birthDate, birthplace, gender, salary));
    }
}
