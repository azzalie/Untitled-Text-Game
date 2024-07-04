public class Main {
    private static final LocationConstructor locationConstructor =
            new LocationConstructor();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            String command = InputHandler.getUserInput();

            if (command.matches("n")) {
                Location startingLocation = locationConstructor.getLocation("Центр");
                GameLoop gameLoop = new GameLoop(locationConstructor, startingLocation);
                gameLoop.start();
            } else if (command.matches("c")) {
                Location startingLocation = locationConstructor.getLocation("Вершина II");
                GameLoop gameLoop = new GameLoop(locationConstructor, startingLocation);
                gameLoop.start();
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

    private static void displayMenu() {
        System.out.println("n.Начать игру");
        System.out.println("c.Продолжить игру");
        System.out.println("x.Выход");
        System.out.print("> ");
    }
}
