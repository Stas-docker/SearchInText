package reader;

import java.util.Scanner;

public class ConsoleIntReader implements IntReader {
    @Override
    public int readInt(Scanner scanner) {
        String value = readLine(scanner);
        while (!isInteger(value)) {
            System.out.println("This is not a number");
            value = readLine(scanner);
        }
        return Integer.parseInt(value);
    }

    @Override
    public boolean isInteger(String value) {
        boolean isInteger;
        try {
            Integer.parseInt(value);
            isInteger = true;
        } catch (NumberFormatException n) {
            isInteger = false;
        }
        return isInteger;
    }
}
