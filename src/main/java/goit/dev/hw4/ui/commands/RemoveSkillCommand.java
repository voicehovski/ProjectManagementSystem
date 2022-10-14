package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.DeleteSkillController;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.ui.View;

public class RemoveSkillCommand implements Command {
    public static final String NAME = "remove skill";
    public static final String DESC = "Remove skill";

    private DeleteSkillController controller;
    private View view;

    public RemoveSkillCommand(DeleteSkillController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        view.write("Enter skill id");
        String id = view.read();
        controller.delete(new IdDto(Long.parseLong(id)));
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
