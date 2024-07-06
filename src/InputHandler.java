import java.util.Scanner;

/**
 * Класс InputHandler отвечает за обработку ввода пользователя
 */
public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Получает строку ввода пользователя с консоли, удаляет пробельные символы
     * с начала и конца строки
     *
     * @return Строка ввода пользователя, очищенная от пробелов
     */
    public static String getUserInput() {
        return scanner.nextLine().trim();
    }

    /**
     * Закрывает сканер для ввода
     */
    public static void closeScanner() {
        scanner.close();
    }
}
