package game;

import game.domain.Enemy;
import game.domain.MainCharacter;

public class View {
    void printHelloMessage() {
        System.out.println("Hello user.");
        System.out.println("You will be playing as very bad guy.");
        System.out.println("You were real criminal. You robbed banks, stole cars, ");
        System.out.println("didn't pay taxes and even don't wash hands after toilet.");
        System.out.println("President of the World appointed a reward for your head!");
        System.out.println("And all special law enforcement units, bounty hunters ");
        System.out.println("and people who wants to get rich are hunting for you.");
        System.out.println("Fight for you life or hide!");
    }

    void printStartGame() {
        System.out.println("To start new game enter 'new'.");
        System.out.println("To load old game enter 'load'.");
    }

    void printHelpMessage() {
        System.out.println("You can save game (command 'save').");
        System.out.println("You can move to next place (command 'move').");
        System.out.println("You can print this help (command 'help').");
        System.out.println("You can check your status (command 'info').");
        System.out.println("You can quit game (command 'quit').");
    }

    public void printMainCharacterCreation() {
        System.out.println("Enter name of your character.");
    }

    public void printSaveCharacter() {
        System.out.println("Your character was saved");
    }

    void printEnterNewPlace() {
        System.out.println("You are entering new place.");
    }

    void printEnemyInfo(Enemy enemy) {
        System.out.printf("You encountered with %s. Health: %d, strength: %d. You will get %d experience if you win.%n",
                enemy.getName(), enemy.getHealth(), enemy.getStrength(), enemy.getExperience());
    }

    void printFightOrRunInfo() {
        System.out.println("You can fight with enemy (command 'fight') or you can run (command 'run').");
    }

    void printRunMessage() {
        System.out.println("You've just ran away from your enemy.");
    }

    void printLoseMessage() {
        System.out.println("YOU ARE DEAD!");
    }

    public void printWinFightMessage(MainCharacter mainCharacter, Enemy enemy) {
        System.out.println("You won this fight. Not bad. But this is not the end.");
        System.out.println("You get " + enemy.getExperience()
                + " experience, and your experience now is " + mainCharacter.getExperience()
                + ". Your health: " + mainCharacter.getHealth() + ", strength: " + mainCharacter.getStrength()
                + ", level: " + mainCharacter.getLevel() + ".");
    }

    void printMainCharacterStatus(MainCharacter mainCharacter) {
        System.out.println("Your character's name is " + mainCharacter.getName() + ", level: " + mainCharacter.getLevel()
                + ", health: " + mainCharacter.getHealth() + ", strength: " + mainCharacter.getStrength()
                + ", experience: " + mainCharacter.getExperience() + ".");
    }
}
