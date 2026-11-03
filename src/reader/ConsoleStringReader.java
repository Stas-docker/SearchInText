package reader;

import java.util.Scanner;

public class ConsoleStringReader implements ConsoleReader {
    @Override
    public String readLine(final Scanner scanner) {
        String string = scanner.nextLine();
        while (string.isBlank()) {
            System.out.println("String cannot be blank, please enter something");
            string = scanner.nextLine();
        }
        return string;
    }
}
