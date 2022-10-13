package goit.dev.hw4.ui;

import goit.dev.hw4.api.controller.SelectDevelopersBySkillLevelContorller;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;

import java.util.List;

// todo В базе level - enum и при передаче постороннего значения происходит ошибка
public class GetDevelopersBySkillLevelCommand implements Command {
    public static final String NAME = "skill level";

    private SelectDevelopersBySkillLevelContorller controller;
    private View view;

    public GetDevelopersBySkillLevelCommand(SelectDevelopersBySkillLevelContorller controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        view.write("Enter skill level");
        String trend = view.read();
        List<DeveloperDto> developers = controller.select(new FilterByStringDto(trend));

        if (developers.isEmpty()){
            view.write("No developers with such skill level");
            return;
        }

        developers.stream()
                .map(dto -> dto.toString())
                .forEach(view::write);
    }
}
