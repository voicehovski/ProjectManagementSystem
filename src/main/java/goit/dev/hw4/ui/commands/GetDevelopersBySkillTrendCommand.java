package goit.dev.hw4.ui.commands;


import goit.dev.hw4.api.controller.SelectDevelopersBySkillTrendContorller;
import goit.dev.hw4.model.dto.DeveloperDto;
import goit.dev.hw4.model.dto.FilterByStringDto;
import goit.dev.hw4.ui.View;

import java.util.List;

public class GetDevelopersBySkillTrendCommand implements Command{
    public static final String NAME = "developers(st)";
    public static final String DESC = "Show developers with particular skill trend";

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

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDesc() {
        return DESC;
    }
}
