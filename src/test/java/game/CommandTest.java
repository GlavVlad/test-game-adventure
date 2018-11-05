package game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandTest {
    @ParameterizedTest
    @CsvSource({
            "new, NEW", "nEw, NEW",
            "SaVe, SAVE", "save, SAVE",
            "LOAD, LOAD", "lOad, LOAD",
            "RUN, RUN", "rUN, RUN",
            "Fight, FIGHT", "fight, FIGHT",
            "MoVe, MOVE", "move, MOVE",
            "HELP, HELP", "heLp, HELP",
            "INFO, INFO", "inFO, INFO",
            "QUit, QUIT", "QUIT, QUIT",
            "LJfsd, HELP"
    })
    void getCommandTest(String command, Command expected) {
        assertEquals(expected, Command.getCommand(command));
    }
}