package goit.dev.hw4.ui.commands;

public interface Command {
    boolean canExecute(String command);
    void execute();
    String getName();
    String getDesc();
}
