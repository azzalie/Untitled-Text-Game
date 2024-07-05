import java.util.ArrayList;
import java.util.List;

public class NPCConstructor {
    private final List<NPC> npcs;

    public NPCConstructor() {
        this.npcs = new ArrayList<>();
        initializeNpcs();
    }

    private void initializeNpcs() {
        npcs.add(new NPC("НПС I", "Описание НПС I", "еще нет"));
        npcs.add(new NPC("НПС II", "Описание НПС II", "еще нет"));
        npcs.add(new NPC("НПС III", "Описание НПС III", "еще нет"));
        npcs.add(new NPC("НПС IV", "Описание НПС IV", "еще нет"));
    }

    public NPC getNpc(String name) {
        for (NPC npc : npcs) {
            if (npc.getName().equalsIgnoreCase(name)) {
                return npc;
            }
        }
        return null;
    }
}
