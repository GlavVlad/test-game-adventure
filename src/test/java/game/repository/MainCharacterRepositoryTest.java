package game.repository;

import game.domain.MainCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainCharacterRepositoryTest {

    @Test
    void SaveAndLoadTest() {
        MainCharacter mainCharacter = new MainCharacter("test");
        MainCharacterRepository repository = new MainCharacterRepository();
        repository.save(mainCharacter);
        MainCharacter loadedMainCharacter = repository.load();
        assertEquals(mainCharacter, loadedMainCharacter);
    }

}