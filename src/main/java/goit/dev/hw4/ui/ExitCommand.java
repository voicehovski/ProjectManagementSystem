package goit.dev.hw4.ui;

public class ExitCommand implements Command {
    public static final String NAME = "exit";

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        //System.exit(0);
    }
}
