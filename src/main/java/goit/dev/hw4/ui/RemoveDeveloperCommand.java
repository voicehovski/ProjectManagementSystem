package goit.dev.hw4.ui;

import goit.dev.hw4.api.controller.DeleteDeveloperController;
import goit.dev.hw4.model.dto.IdDto;

public class RemoveDeveloperCommand implements Command {

    public static final String NAME = "remove developer";

    private DeleteDeveloperController controller;
    private View view;

    public RemoveDeveloperCommand(DeleteDeveloperController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        view.write("Enter developer id");
        String id = view.read();
        controller.delete(new IdDto(Long.parseLong(id)));
        // todo Что-то нужно возвращать для контроля?
    }
}
