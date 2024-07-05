public class CurrentNPCLoop {
    private final NPC npc;
    private final Player player;
    private boolean firstMeeting = true;

    public CurrentNPCLoop(NPC npc, Player player) {
        this.npc = npc;
        this.player = player;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println(npc.getName());
            System.out.println("^" + npc.getDescription() + "^");
            System.out.println(npc.getReplica());

            if (firstMeeting) {
                giveInitialGiftItems();
                firstMeeting = false;
            }

            System.out.println("n.Отойти");
            System.out.print("|> ");
            String command = InputHandler.getUserInput();

            if (command.equalsIgnoreCase("n")) {
                running = false;
            } else {
                System.out.println("\n!неверный выбор!\n");
            }

            System.out.println();
        }
    }

    private void giveInitialGiftItems() {
        for (Item item : npc.getInitialGiftItems()) {
            player.getInventory().takeItem(item);
            System.out.println(npc.getName() + " дал вам " + item.getName());
        }
        npc.getInitialGiftItems().clear();
    }
}
