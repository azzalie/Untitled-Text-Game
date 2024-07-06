/**
 * Главный класс игры
 */
public class Main {
    private static final LocationConstructor locationConstructor =
            new LocationConstructor();

    /**
     * Точка входа в программу
     */
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            String command = InputHandler.getUserInput();
            System.out.println("--------------------------------\n\n");

            if (command.matches("n")) {
                showIntro();
                startGame("Центр");

            } else if (command.matches("c")) {
                startGame("Вершина III");

            } else if (command.matches("x")) {
                running = false;
                System.out.println("... выход из игры ...");
                InputHandler.closeScanner();

            } else {
                System.out.println("!неверный выбор!");
            }
            System.out.println();
        }
        InputHandler.closeScanner();
    }

    /**
     * Выводит вступительное предисловие с описанием игры и обозначениями
     */
    private static void showIntro() {
        System.out.println(
                """
                        +---------------------Цель игры:---------------------+
                        |    >Ваша задача - собрать уникальные предметы      |
                        |    >Предметы находятся в разных локациях и у НПС   |
                        |    >Найдите их и доставьте в центр                 |
                        +----------------------------------------------------+
                        """
        );
        System.out.println(
                """
                        +------Обозначения:------+
                        |      <Заголовки>       |
                        |       ^Описания^       |
                        |    ... действие ...    |
                        |        !ошибки!        |
                        |    [m]Команды меню     |
                        |    |> строка ввода     |
                        +------------------------+
                        """
        );
    }

    /**
     * Запускает игру с указанной стартовой локацией
     *
     * @param name
     *         Название стартовой локации
     */
    private static void startGame(String name) {
        Location startingLocation = locationConstructor.getLocation(name);
        GameLoop gameLoop = new GameLoop(locationConstructor, startingLocation);
        gameLoop.start();
    }

    /**
     * Отображает главное меню игры
     */
    private static void displayMenu() {
        System.out.println("n.Начать игру");
        System.out.println("c.Продолжить игру");
        System.out.println("x.Выход");
        System.out.print("> ");
    }
}
