package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.DeleteDeveloperController;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.ui.View;

public class RemoveDeveloperCommand implements Command {

    public static final String NAME = "remove developer";
    public static final String DESC = "Remove developer with all relations";

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
        int affected = controller.delete(new IdDto(Long.parseLong(id)));
        view .write ( "Removed developers with relations: " + affected );
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
