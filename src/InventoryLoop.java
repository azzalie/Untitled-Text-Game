import java.util.List;

/**
 * Класс InventoryLoop отвечает за управление инвентарем
 */
public class InventoryLoop {
    private final Inventory inventory;
    private final ItemConstructor itemConstructor;
    private final Location currentLocation;
    private String currentItem;

    /**
     * Конструктор InventoryLoop
     *
     * @param inventory
     *         Инвентарь игрока
     * @param itemConstructor
     *         Конструктор предметов
     * @param currentLocation
     *         Текущая локация игрока
     */
    public InventoryLoop(Inventory inventory, ItemConstructor itemConstructor, Location currentLocation) {
        this.inventory = inventory;
        this.currentItem = null;
        this.itemConstructor = itemConstructor;
        this.currentLocation = currentLocation;
    }

    /**
     * Запускает цикл управления инвентарем
     */
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("<Инвентарь>");
            List<String> items = inventory.getItems();

            if (items.isEmpty()) {
                System.out.println("*пусто*");

            } else {
                for (String item : items) {
                    System.out.println(item);

                    if (currentItem != null && currentItem.equalsIgnoreCase(item)) {
                        Item currentItemObject = itemConstructor.getItem(currentItem);

                        if (currentItemObject != null) {
                            System.out.println("^" + currentItemObject.getDescription() + "^");

                        } else {
                            System.out.println("!неизвестный предмет!");
                        }
                    }
                }
            }

            displayMenu();
            String command = InputHandler.getUserInput();
            System.out.println("--------------------------------\n\n");

            if (command.equalsIgnoreCase("i")) {
                running = false;

            } else if (command.equalsIgnoreCase("d")) {
                if (currentItem != null) {
                    Item droppedItem = itemConstructor.createItem(currentItem);

                    if (droppedItem != null) {
                        currentLocation.addItem(droppedItem);
                        inventory.removeItem(currentItem);
                        currentItem = null;
                        System.out.println("... предмет выброшен ...");

                    } else {
                        System.out.println("!ошибка при удалении предмета!");
                    }

                } else {
                    System.out.println("!не выбран предмет!");
                }

            } else {
                if (items.contains(command)) {
                    currentItem = command;
                    Item item = itemConstructor.getItem(currentItem);

                    if (item != null) {
                        System.out.println("^" + item.getDescription() + "^");

                    } else {
                        System.out.println("!неизвестный предмет!");
                    }

                } else {
                    System.out.println("!неверный выбор!");
                }
            }
            System.out.println();
        }
    }

    /**
     * Отображает меню инвентаря
     */
    private void displayMenu() {
        System.out.println();
        System.out.println("[i]Закрыть инвентарь");
        System.out.println("[d]Выбросить текущий предмет");
        System.out.print("|> ");
    }
}
