package goit.dev.hw4.ui.commands;

import goit.dev.hw4.api.controller.AgregateTotalSalaryByProjectController;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.NumberDto;
import goit.dev.hw4.ui.View;

public class GetTotalSalaryByProjectCommand implements Command {
    public static final String NAME = "total salary(p)";
    public static final String DESC = "Show total salary of particular project";

    private AgregateTotalSalaryByProjectController controller;
    private View view;

    public GetTotalSalaryByProjectCommand(AgregateTotalSalaryByProjectController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        view.write("Enter project id");
        String id = view.read();
        NumberDto totalSalaryDto = controller.select(new IdDto(Long.parseLong(id)));
        view.write(totalSalaryDto.getValue());
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
