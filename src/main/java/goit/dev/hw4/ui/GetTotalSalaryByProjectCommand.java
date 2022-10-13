package goit.dev.hw4.ui;

import goit.dev.hw4.api.controller.AgregateTotalSalaryByProjectController;
import goit.dev.hw4.model.dto.IdDto;
import goit.dev.hw4.model.dto.NumberDto;

public class GetTotalSalaryByProjectCommand implements Command {
    public static final String NAME = "total";

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
}
