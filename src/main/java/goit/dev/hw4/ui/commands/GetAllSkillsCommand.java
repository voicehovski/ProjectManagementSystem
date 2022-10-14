package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.SelectSkillController;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.ui.View;

import java.util.List;

public class GetAllSkillsCommand implements Command {
    public static final String NAME = "skills";
    public static final String DESC = "Show all skills";

    private SelectSkillController controller;
    private View view;

    public GetAllSkillsCommand(SelectSkillController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        List<SkillDto> skills = controller.select();

        if (skills.isEmpty()){
            view.write("No skills");
            return;
        }

        skills.stream()
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
