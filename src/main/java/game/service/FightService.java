package game.service;

import game.View;
import game.domain.Enemy;
import game.domain.MainCharacter;

public class FightService {
    private final View view;

    public FightService(View view) {
        this.view = view;
    }

    public void fight(MainCharacter mainCharacter, Enemy enemy) {
        while (true) {
            if (mainCharacter.isAlive() && enemy.isAlive()) {
                enemy.doDamage(mainCharacter.getStrength());
                if (enemy.isAlive()) mainCharacter.doDamage(enemy.getStrength());
                else mainCharacter.updateStats(enemy.getExperience());
            } else {
                if (!enemy.isAlive()) view.printWinFightMessage(mainCharacter, enemy);
                break;
            }
        }
    }
}
