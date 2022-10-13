package goit.dev.hw4.ui;

public class HelpCommand implements Command {
    public static final String NAME = "help";

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        // view.write("Help message");
    }
}
