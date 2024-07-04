import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.nextLine().trim();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
