package goit.dev.hw4.ui;

public interface Command {
    boolean canExecute(String command);
    void execute();
}
