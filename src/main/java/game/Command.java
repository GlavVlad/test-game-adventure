package game;

import java.util.Arrays;

public enum Command {
    NEW("new"),
    SAVE("save"),
    LOAD("load"),
    RUN("run"),
    FIGHT("fight"),
    MOVE("move"),
    HELP("help"),
    INFO("info"),
    QUIT("quit"),
    ;

    private String command;

    Command(String command) {
        this.command = command;
    }

    public static Command getCommand(String commandStr) {
        return Arrays.stream(Command.values())
                .filter(c -> c.command.equalsIgnoreCase(commandStr))
                .findAny()
                .orElse(HELP);
    }
}