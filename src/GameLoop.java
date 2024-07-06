import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Класс GameLoop отвечает за основной игровой цикл
 */
public class GameLoop {
    private final Player player;
    private final LocationConstructor locationConstructor;
    private final ItemConstructor itemConstructor = new ItemConstructor();

    /**
     * Конструктор GameLoop
     *
     * @param locationConstructor
     *         Конструктор локаций
     * @param startingLocation
     *         Начальная локация игрока
     */
    public GameLoop(LocationConstructor locationConstructor, Location startingLocation) {
        this.locationConstructor = locationConstructor;
        player = new Player(startingLocation);
    }

    /**
     * Запускает основной игровой цикл
     */
    public void start() {
        boolean running = true;

        while (running) {
            Location currentLocation = player.getCurrentLocation();
            System.out.println(currentLocation.getName());
            System.out.println("^" + currentLocation.getDescription() + "^");

            System.out.println("<Доступные локации>");

            for (Location neighbor : currentLocation.getNeighbors()) {
                System.out.println(neighbor.getName());
            }

            List<Item> items = currentLocation.getItems();

            if (!items.isEmpty()) {
                System.out.println("<Предметы в локации>");
                for (Item item : items) {
                    System.out.println(item.getName());
                }
            }

            List<NPC> npcs = currentLocation.getNpcs();

            if (!npcs.isEmpty()) {
                System.out.println("<В локации есть NPC>");
            }

            displayMenu(currentLocation);
            String command = InputHandler.getUserInput();
            System.out.println("--------------------------------\n\n");

            if (command.equalsIgnoreCase("x")) {
                running = false;
                System.out.println("\n... игра завершена ...\n");

            } else if (command.equalsIgnoreCase("i")) {
                InventoryLoop inventoryLoop = new InventoryLoop(player.getInventory(), itemConstructor, currentLocation); // Передаем currentLocation
                inventoryLoop.start();

            } else if (command.equalsIgnoreCase("n") && !currentLocation.getNpcs().isEmpty()) {
                NPCLoop npcLoop = new NPCLoop(currentLocation.getNpcs(), player);
                npcLoop.start();

            } else {
                String itemName = command.trim();
                Item itemToTake = null;

                for (Item item : currentLocation.getItems()) {
                    if (item.getName().equalsIgnoreCase(itemName)) {
                        itemToTake = item;
                        break;
                    }
                }

                if (itemToTake != null) {
                    currentLocation.removeItem(itemToTake);
                    player.getInventory().takeItem(itemToTake);
                    System.out.println("\n... вы взяли " + itemToTake.getName() +
                            " ...\n");
                    continue;

                } else {
                    Location newLocation = locationConstructor.getLocation(command);

                    if (newLocation != null) {
                        player.setCurrentLocation(newLocation);

                    } else {
                        System.out.println("\n!неверный выбор!\n");
                    }
                }
            }

            System.out.println();

            if (isGameWon()) {
                running = false;
                System.out.println("\n... !!!игра пройдена!!! ...\n");
            }
        }
    }

    /**
     * Проверяет, выиграл ли игрок.
     *
     * @return true, если игрок выиграл, иначе false
     */
    private boolean isGameWon() {
        Location centerLocation = locationConstructor.getLocation("Центр");

        if (centerLocation != null) {
            List<Item> itemsInCenter = centerLocation.getItems();
            Set<String> uniqueItemNames = new HashSet<>();

            for (Item item : itemsInCenter) {
                uniqueItemNames.add(item.getName());
            }
            return uniqueItemNames.size() >= 4;
        }
        return false;
    }

    /**
     * Отображает меню игры
     *
     * @param currentLocation
     *         Текущая локация игрока
     */
    private void displayMenu(Location currentLocation) {
        System.out.println();
        System.out.println("[i]Открыть инвентарь");

        if (!currentLocation.getNpcs().isEmpty()) {
            System.out.println("[n]NPC");
        }
        System.out.println("[x]Завершить игру");
        System.out.print("|> ");
    }
}
