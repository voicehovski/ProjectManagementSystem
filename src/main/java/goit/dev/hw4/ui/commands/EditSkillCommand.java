package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.UpdateSkillController;
import goit.dev.hw4.api.controller.SelectSkillController;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.ui.View;

import java.util.List;
import java.util.stream.Collectors;

public class EditSkillCommand implements Command {

    public static final String NAME = "edit skill";
    public static final String DESC = "Edit existed skill";

    private UpdateSkillController controller;
    private SelectSkillController selectController;
    private View view;

    public EditSkillCommand(UpdateSkillController controller, SelectSkillController selectController, View view) {
        this.controller = controller;
        this.selectController = selectController;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        List<SkillDto> existedSkills = selectController.select();
        String validLevels = existedSkills.stream()
                .map(skillDto -> skillDto.getLevel())
                .distinct()
                .collect(Collectors.joining(", "));

        view.write("Enter id");
        long id = Long.parseLong(view.read());
        view.write("Enter trend");
        String trend = view.read();
        view.write("Enter level of: " + validLevels);
        String level = view.read();

        controller.update(new SkillDto(id, trend, level));
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
