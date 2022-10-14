package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.InsertSkillController;
import goit.dev.hw4.api.controller.SelectSkillController;
import goit.dev.hw4.model.dto.SkillDto;
import goit.dev.hw4.ui.View;

import java.util.List;
import java.util.stream.Collectors;

public class CreateSkillCommand implements Command {
    public static final String NAME = "create skill";
    public static final String DESC = "Create new skill";

    private InsertSkillController controller;
    private SelectSkillController selectController;
    private View view;

    public CreateSkillCommand(InsertSkillController controller, SelectSkillController selectController, View view) {
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

        view.write("Enter trend");
        String trend = view.read();
        view.write("Enter level of: " + validLevels);
        String level = view.read();

        controller.insert(new SkillDto(trend, level));
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
