package goit.dev.hw4.ui;


import goit.dev.hw4.api.controller.SelectDevelopersBySkillTrendContorller;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.NumberDto;

import java.util.List;

public class GetDevelopersBySkillTrendCommand implements Command{
    public static final String NAME = "skill trend";

    private SelectDevelopersBySkillTrendContorller controller;
    private View view;

    public GetDevelopersBySkillTrendCommand(SelectDevelopersBySkillTrendContorller controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        view.write("Enter skill trend");
        String trend = view.read();
        List<DeveloperDto> developers = controller.select(new FilterByStringDto(trend));

        if (developers.isEmpty()){
            view.write("No developers with such skill trend");
            return;
        }

        developers.stream()
                .map(dto -> dto.toString())
                .forEach(view::write);
    }
}
