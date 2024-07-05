public class CurrentNPCLoop {
    private final NPC npc;

    public CurrentNPCLoop(NPC npc) {
        this.npc = npc;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println(npc.getName());
            System.out.println("^" + npc.getDescription() + "^");
            System.out.println(npc.getReplica());

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
}
