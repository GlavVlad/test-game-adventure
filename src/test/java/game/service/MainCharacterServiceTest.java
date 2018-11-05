package game.service;

import game.View;
import game.domain.MainCharacter;
import game.repository.MainCharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MainCharacterServiceTest {
    @Mock
    private CLIService cliService;

    @Mock
    private View view;

    @Mock
    private MainCharacterRepository mainCharacterRepository;

    @InjectMocks
    private MainCharacterService service;

    @Test
    void createMainCharacter() {
        doNothing().when(view).printMainCharacterCreation();
        when(cliService.readLine()).thenReturn("test");
        service.createMainCharacter();
        verify(view).printMainCharacterCreation();
        verify(cliService).readLine();
    }

    @Test
    void loadMainCharacter() {
        service.loadMainCharacter();
        verify(mainCharacterRepository).load();
    }

    @Test
    void saveMainCharacter() {
        MainCharacter mainCharacter = new MainCharacter("test");
        service.saveMainCharacter(mainCharacter);
        verify(mainCharacterRepository).save(eq(mainCharacter));
    }

    @Test
    void createDefaultMainCharacter() {
        MainCharacter expectedMainCharacter = new MainCharacter("default name");
        MainCharacter defaultMainCharacter = service.createDefaultMainCharacter();
        assertEquals(expectedMainCharacter, defaultMainCharacter);
    }
}