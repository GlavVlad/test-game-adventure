package game.service;

import game.View;
import game.domain.MainCharacter;
import game.repository.MainCharacterRepository;

public class MainCharacterService {
    private final CLIService cliService;
    private final View view;
    private final MainCharacterRepository repository;

    public MainCharacterService(CLIService cliService, View view, MainCharacterRepository repository) {
        this.cliService = cliService;
        this.view = view;
        this.repository = repository;
    }

    public MainCharacter createMainCharacter() {
        view.printMainCharacterCreation();
        return new MainCharacter(cliService.readLine());
    }

    public MainCharacter loadMainCharacter() {
        return repository.load();
    }

    public void saveMainCharacter(MainCharacter mainCharacter) {
        repository.save(mainCharacter);
        view.printSaveCharacter();
    }

    public MainCharacter createDefaultMainCharacter() {
        return new MainCharacter("default name");
    }
}
