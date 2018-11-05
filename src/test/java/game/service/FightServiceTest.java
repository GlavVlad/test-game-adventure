package game.service;

import game.View;
import game.domain.Enemy;
import game.domain.MainCharacter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FightServiceTest {
    private View view = new View();
    private FightService service = new FightService(view);

    @ParameterizedTest
    @CsvSource({
            "1,     1,    1,    1,    10000, 100, 0, true,  false",
            "500,   1,    1,    1,    9996,  100, 0, true,  false",
            "500,   1,    1000, 1000, 11000, 110, 1, true,  false",
            "10000, 1000, 1000, 0,    0,     100, 0, false, true"
    })
    void fightTest(
            int enemyHealth, int enemyStrength, int enemyExperience,
            int expectedExperience, int expectedHealth, int expectedStrength, int expectedLevel,
            boolean expectedMainCharacterIsAlive, boolean expectedEnemyIsAlive
    ) {
        MainCharacter mainCharacter = new MainCharacter("test");
        Enemy enemy = new Enemy("test enemy", enemyHealth, enemyStrength, enemyExperience);
        service.fight(mainCharacter, enemy);

        assertAll(
                () -> assertEquals(expectedMainCharacterIsAlive, mainCharacter.isAlive(), "expected main character alive status doesn't equal to actual"),
                () -> assertEquals(expectedEnemyIsAlive, enemy.isAlive(), "expected enemy alive status doesn't equal to actual"),
                () -> assertEquals(expectedExperience, mainCharacter.getExperience(), "expected experience doesn't equal to actual experience"),
                () -> assertEquals(expectedHealth, mainCharacter.getHealth(), "expected health doesn't equal to actual health"),
                () -> assertEquals(expectedStrength, mainCharacter.getStrength(), "expected strength doesn't equal to actual strength"),
                () -> assertEquals(expectedLevel, mainCharacter.getLevel(), "expected level doesn't equal to actual level")
        );
    }
}