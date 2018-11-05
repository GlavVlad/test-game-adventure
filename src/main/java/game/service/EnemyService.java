package game.service;

import game.domain.Enemy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemyService {
    private final static Enemy REGULAR_ENEMY = new Enemy("Regular enemy", 1000, 100, 100);
    private final static Enemy POLICEMAN = new Enemy("Policeman", 2000, 200, 200);
    private final static Enemy BOUNTY_HUNTER = new Enemy("Bounty hunter", 3000, 300, 300);
    private final static Enemy SWAT = new Enemy("SWAT", 4000, 400, 400);
    private final static Enemy SPEC_OPS = new Enemy("Spec Ops", 5000, 500, 500);
    private final static List<Enemy> enemies = Arrays.asList(REGULAR_ENEMY, POLICEMAN, BOUNTY_HUNTER, SWAT, SPEC_OPS);
    private final static Random RANDOM = new Random();

    public Enemy getRandomEnemy() {
        return enemies.get(RANDOM.nextInt(enemies.size()));
    }
}