package game;

import game.domain.Enemy;
import game.domain.MainCharacter;
import game.repository.MainCharacterRepository;
import game.service.CLIService;
import game.service.EnemyService;
import game.service.FightService;
import game.service.MainCharacterService;

public class Game {

    private final View view;
    private final CLIService cliService;
    private final EnemyService enemyService;
    private final FightService fightService;
    private final MainCharacterService mainCharacterService;

    private Game(View view, CLIService cliService, EnemyService enemyService, FightService fightService, MainCharacterService mainCharacterService) {
        this.view = view;
        this.cliService = cliService;
        this.enemyService = enemyService;
        this.fightService = fightService;
        this.mainCharacterService = mainCharacterService;
    }

    public static void main(String[] args) {
        View view = new View();
        CLIService cliService = new CLIService();
        EnemyService enemyService = new EnemyService();
        FightService fightService = new FightService(view);
        MainCharacterService mainCharacterService = new MainCharacterService(cliService, view, new MainCharacterRepository());
        new Game(view, cliService, enemyService, fightService, mainCharacterService).start();
    }

    private void start() {
        view.printHelloMessage();
        view.printStartGame();

        MainCharacter mainCharacter = getMainCharacter();

        view.printHelpMessage();

        loop:
        while (mainCharacter.isAlive()) {
            switch (cliService.readLineAndParseCommand()) {
                case MOVE:
                    move(mainCharacter);
                    break;

                case HELP:
                    view.printHelpMessage();
                    break;

                case INFO:
                    view.printMainCharacterStatus(mainCharacter);
                    break;

                case SAVE:
                    mainCharacterService.saveMainCharacter(mainCharacter);
                    break;

                case QUIT:
                    break loop;
            }
        }

        if (!mainCharacter.isAlive()) view.printLoseMessage();
    }

    void move(MainCharacter mainCharacter) {
        view.printEnterNewPlace();
        Enemy randomEnemy = enemyService.getRandomEnemy();
        view.printEnemyInfo(randomEnemy);
        view.printFightOrRunInfo();
        switch (cliService.readLineAndParseCommand()) {
            case RUN:
                view.printRunMessage();
                break;
            case FIGHT:
                fightService.fight(mainCharacter, randomEnemy);
                break;
        }
    }

    MainCharacter getMainCharacter() {
        MainCharacter mainCharacter;
        switch (cliService.readLineAndParseCommand()) {
            case NEW:
                mainCharacter = mainCharacterService.createMainCharacter();
                break;
            case LOAD:
                mainCharacter = mainCharacterService.loadMainCharacter();
                break;
            default:
                mainCharacter = mainCharacterService.createDefaultMainCharacter();
        }
        return mainCharacter;
    }
}