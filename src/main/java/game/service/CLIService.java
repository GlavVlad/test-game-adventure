package game.service;

import game.Command;

import java.util.Scanner;

public class CLIService {
    private Scanner scanner = new Scanner(System.in);

    String readLine() {
        return scanner.nextLine();
    }

    public Command readLineAndParseCommand() {
        return Command.getCommand(readLine());
    }
}
