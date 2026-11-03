package reader;

import utils.UserChoice;

import java.util.Scanner;

public class UserChoiceReader {
    private IntReader intReader;

    public UserChoiceReader(IntReader intReader) {
        this.intReader = intReader;
    }

    public UserChoice processUserChoice(final Scanner scanner) {
        UserChoice choice = readUserChoice(scanner);
        while (!choiceIsValid(choice)) {
            System.out.println("Please choose 1 or 2: ");
            choice = readUserChoice(scanner);
        }
        return choice;
    }

    private boolean choiceIsValid(UserChoice choice) {
        boolean isValid;
        if (choice == UserChoice.CONTINUE || choice == UserChoice.EXIT) {
            isValid = true;
        } else isValid = false;
        return isValid;
    }

    private UserChoice readUserChoice(final Scanner scanner) {
        final int fromCode = intReader.readInt(scanner);
        return UserChoice.fromCode(fromCode);
    }
}
