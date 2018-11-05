package game.repository;

import game.domain.MainCharacter;

import java.io.*;

public class MainCharacterRepository {
    private static final String DEFAULT_SAVE_FILENAME = "save.game";

    public void save(MainCharacter mainCharacter) {
        try (FileOutputStream fos = new FileOutputStream(DEFAULT_SAVE_FILENAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(mainCharacter);
        } catch (IOException ex) {
            throw new RuntimeException("The game hasn't been saved.");
        }
    }

    public MainCharacter load() {
        try (FileInputStream fis = new FileInputStream(DEFAULT_SAVE_FILENAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (MainCharacter) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException("The game hasn't been loaded.");
        }
    }
}
