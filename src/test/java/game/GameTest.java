package game;

import game.domain.MainCharacter;
import game.service.CLIService;
import game.service.EnemyService;
import game.service.FightService;
import game.service.MainCharacterService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {
    @Mock
    private View view;

    @Mock
    private CLIService cliService;

    @Mock
    private EnemyService enemyService;

    @Mock
    private FightService fightService;

    @Mock
    private MainCharacterService mainCharacterService;

    @Spy
    @InjectMocks
    private Game game;

    @ParameterizedTest
    @CsvSource({
            "RUN,   true",
            "FIGHT, false"
    })
    void moveTest(Command command, boolean isPrintRunMessage) {
        MainCharacter mainCharacter = new MainCharacter("test");
        when(cliService.readLineAndParseCommand()).thenReturn(command);

        game.move(mainCharacter);

        verify(view).printEnterNewPlace();
        verify(enemyService).getRandomEnemy();
        verify(view).printEnemyInfo(any());
        verify(view).printFightOrRunInfo();
        if (isPrintRunMessage) verify(view).printRunMessage();
        else verify(fightService).fight(mainCharacter, null);
    }

    @ParameterizedTest
    @CsvSource({
            "NEW,  test,    true,  false, false",
            "LOAD, loaded,  false, true,  false",
            "MOVE, default, false, false, true"
    })
    void getMainCharacterTest(Command command, String expectedName, boolean isNew, boolean isLoaded, boolean isDefault) {
        when(cliService.readLineAndParseCommand()).thenReturn(command);
        if (isNew) when(mainCharacterService.createMainCharacter()).thenReturn(new MainCharacter(expectedName));

        if (isLoaded) when(mainCharacterService.loadMainCharacter()).thenReturn(new MainCharacter(expectedName));

        if (isDefault)
            when(mainCharacterService.createDefaultMainCharacter()).thenReturn(new MainCharacter(expectedName));

        MainCharacter mainCharacter = game.getMainCharacter();

        assertEquals(expectedName, mainCharacter.getName());
    }
}