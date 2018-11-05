package game.domain;

public class Enemy {
    private final String name;
    private final int strength;
    private final int experience;
    private int health;

    public Enemy(String name, int health, int strength, int experience) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getExperience() {
        return experience;
    }

    public void doDamage(int mainCharacterStrength) {
        health -= mainCharacterStrength;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }
}
