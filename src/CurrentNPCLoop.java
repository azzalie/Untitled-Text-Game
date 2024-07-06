/**
 * Класс CurrentNPCLoop отвечает за взаимодействие с выбранным NPC
 */
public class CurrentNPCLoop {
    private final NPC npc;
    private final Player player;

    /**
     * Конструктор CurrentNPCLoop
     *
     * @param npc
     *         NPC, с которым происходит взаимодействие
     * @param player
     *         Игрок
     */
    public CurrentNPCLoop(NPC npc, Player player) {
        this.npc = npc;
        this.player = player;
    }

    /**
     * Отображает меню для взаимодействия с NPC
     */
    public static void displayMenu() {
        System.out.println("[n]Отойти");
        System.out.print("|> ");
    }

    /**
     * Запускает цикл взаимодействия с NPC
     */
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println(npc.getName());
            System.out.println("^" + npc.getDescription() + "^");

            if (npc.isFirstMeeting()) {
                giveInitialGiftItems();
                npc.setFirstMeeting(false);
                System.out.println("\n" + npc.getName() + ": " + npc.getReplica() + "\n");

            } else {
                System.out.println("\n" + npc.getName() + ": ..." + "\n");
            }


            displayMenu();
            String command = InputHandler.getUserInput();
            System.out.println("--------------------------------\n\n");

            if (command.equalsIgnoreCase("n")) {
                running = false;

            } else {
                System.out.println("\n!неверный выбор!\n");
            }
            System.out.println();
        }
    }

    /**
     * Передает начальные предметы NPC игроку
     */
    private void giveInitialGiftItems() {
        for (Item item : npc.getInitialGiftItems()) {
            player.getInventory().takeItem(item);
            System.out.println("..." + npc.getName() + " дал вам " + item.getName() + "...");
        }
        npc.getInitialGiftItems().clear();
    }
}
