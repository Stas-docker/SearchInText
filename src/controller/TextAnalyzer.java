package controller;

import reader.*;
import utils.UserChoice;
import utils.Utils;
import view.Menu;

import java.util.List;
import java.util.Scanner;

public class TextAnalyzer {
    private static final ConsoleReader CONSOLE_READER = new ConsoleStringReader();
    private static final IntReader INT_READER = new ConsoleIntReader();
    private static final UserChoiceReader USER_CHOICE_READER = new UserChoiceReader(INT_READER);

    public void processText() {
        try (final Scanner scanner = new Scanner(System.in)) {
            UserChoice choice = UserChoice.UNKNOWN;
            while (choice != UserChoice.EXIT) {
                Menu.startMenu();
                containsNeededWords(scanner);
                Menu.continueMenu();
                choice = USER_CHOICE_READER.processUserChoice(scanner);
            }
        }
    }

    private List<String> getListOfWords(final Scanner scanner) {
        final String stringToAnalise = CONSOLE_READER.readLine(scanner);
        System.out.println("\nNow type the symbols and I will find the words which start with these: ");
        final String startLetters = CONSOLE_READER.readLine(scanner);
        return Utils.getWordsFromString(stringToAnalise, startLetters);
    }

    private void containsNeededWords(final Scanner scanner) {
        final List<String> words = getListOfWords(scanner);
        if (words.isEmpty()) {
            System.out.println("\nThere is no words starting with these symbols\n");
        } else {
            System.out.println("\nWords starting with these symbols are: " + words + "\n");
        }
    }
}
