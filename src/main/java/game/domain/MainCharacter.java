package game.domain;

import java.io.Serializable;
import java.util.Objects;

public class MainCharacter implements Serializable {
    private static final long serialVersionUID = 42L;
    private static final int INITIAL_HEALTH = 10000;
    private static final int INITIAL_STRENGTH = 100;
    private static final int EXPERIENCE_PER_LEVEL = 1000;
    private static final int HEALTH_FOR_LEVEL_UP = 1000;
    private static final int STRENGTH_FOR_LEVEL_UP = 10;
    private final String name;
    private int health;
    private int experience;
    private int level;
    private int strength;

    public MainCharacter(String name) {
        this.name = name;
        this.health = INITIAL_HEALTH;
        this.strength = INITIAL_STRENGTH;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void doDamage(int enemyStrength) {
        health -= enemyStrength;
    }

    public void updateStats(int experienceFromEnemy) {
        experience += experienceFromEnemy;
        if (experience / EXPERIENCE_PER_LEVEL > level) {
            level++;
            health = INITIAL_HEALTH + level * HEALTH_FOR_LEVEL_UP;
            strength += STRENGTH_FOR_LEVEL_UP;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainCharacter that = (MainCharacter) o;
        return health == that.health &&
                experience == that.experience &&
                level == that.level &&
                strength == that.strength &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, experience, level, strength);
    }
}