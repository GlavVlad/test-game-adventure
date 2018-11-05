package game.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainCharacterTest {

    @Test
    void doDamageTest() {
        MainCharacter mainCharacter = new MainCharacter("test");
        int healthBeforeDamage = mainCharacter.getHealth();
        int damage = 100;
        mainCharacter.doDamage(damage);
        int healthAfterDamage = mainCharacter.getHealth();
        Assertions.assertEquals(healthBeforeDamage - healthAfterDamage, damage);
    }

    @ParameterizedTest
    @CsvSource({
            "1,    1,    10000, 100, 0",
            "1200, 1200, 11000, 110, 1"
    })
    void updateStatsTest(int experienceFromEnemy, int expectedExperience, int expectedHealth, int expectedStrength, int expectedLevel) {
        MainCharacter mainCharacter = new MainCharacter("test");
        mainCharacter.updateStats(experienceFromEnemy);
        assertAll(
                () -> assertEquals(expectedExperience, mainCharacter.getExperience(), "expected experience doesn't equal to actual experience"),
                () -> assertEquals(expectedHealth, mainCharacter.getHealth(), "expected health doesn't equal to actual health"),
                () -> assertEquals(expectedStrength, mainCharacter.getStrength(), "expected strength doesn't equal to actual strength"),
                () -> assertEquals(expectedLevel, mainCharacter.getLevel(), "expected level doesn't equal to actual level")
        );
    }
}