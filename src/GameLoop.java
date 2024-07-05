import java.util.List;

public class GameLoop {
    private final LocationConstructor locationConstructor;
    private final Player player;
    private final ItemConstructor itemConstructor = new ItemConstructor();

    public GameLoop(LocationConstructor locationConstructor, Location startingLocation) {
        this.locationConstructor = locationConstructor;
        this.player = new Player(startingLocation);
    }

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
                System.out.println("<NPC в локации>");
                for (NPC npc : npcs) {
                    System.out.println(npc.getName());
                }
            }

            displayGameMenu(currentLocation);
            String command = InputHandler.getUserInput();

            if (command.equalsIgnoreCase("x")) {
                running = false;
                System.out.println("\n... игра завершена ...\n");
            } else if (command.equalsIgnoreCase("i")) {
                InventoryLoop inventoryLoop = new InventoryLoop(player.getInventory(), itemConstructor, currentLocation); // Передаем currentLocation
                inventoryLoop.start();
            } else if (command.equalsIgnoreCase("n") && !currentLocation.getNpcs().isEmpty()) {
                NPCLoop npcLoop = new NPCLoop(currentLocation.getNpcs());
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
        }
    }

    private void displayGameMenu(Location currentLocation) {
        System.out.println();
        System.out.println("i.Открыть инвентарь");
        if (!currentLocation.getNpcs().isEmpty()) {
            System.out.println("n.NPC");
        }
        System.out.println("x.Завершить игру");
        System.out.print("|> ");
    }
}
