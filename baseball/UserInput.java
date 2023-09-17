package baseball;

import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public UserRequest inputNumbers() {
        return new UserRequest(scanner.nextLine());
    }

    public boolean restart() {
        return scanner.nextInt() == 1;
    }
}
