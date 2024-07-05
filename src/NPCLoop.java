import java.util.List;

public class NPCLoop {
    private final List<NPC> npcs;
    private final Player player;

    public NPCLoop(List<NPC> npcs, Player player) {
        this.npcs = npcs;
        this.player = player;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("<NPC в локации>");
            for (NPC npc : npcs) {
                System.out.println(npc.getName());
            }

            displayNpcMenu();
            String command = InputHandler.getUserInput();
            System.out.println("--------------------------------\n\n");

            if (command.equalsIgnoreCase("n")) {
                running = false;
            } else {
                for (NPC npc : npcs) {
                    if (npc.getName().equalsIgnoreCase(command)) {
                        CurrentNPCLoop currentNPCLoop =
                                new CurrentNPCLoop(npc, player);
                        currentNPCLoop.start();
                        break;
                    }
                }
                if (!command.equalsIgnoreCase("n")) {
                    System.out.println("\n!неверный выбор!\n");
                }
            }

            System.out.println();
        }
    }

    private void displayNpcMenu() {
        System.out.println();
        System.out.println("[n]Уйти от NPC");
        System.out.print("|> ");
    }
}
