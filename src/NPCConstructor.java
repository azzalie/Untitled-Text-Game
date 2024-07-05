import java.util.HashMap;
import java.util.Map;

public class NPCConstructor {
    private final Map<String, NPC> npcs;
    private final NPCReplicasContent replicasContent = new NPCReplicasContent();

    public NPCConstructor(ItemConstructor itemConstructor) {
        npcs = new HashMap<>();
        initializeNpcs();
        ItemNPCSetup.setupItems(this, itemConstructor);
    }

    private void initializeNpcs() {
        NPC npcI = new NPC("НПС I", "Описание НПС I", replicasContent.getReplicaForNpcI());
        NPC npcII = new NPC("НПС II", "Описание НПС II", replicasContent.getReplicaForNpcII());
        NPC npcIII = new NPC("НПС III", "Описание НПС III", replicasContent.getReplicaForNpcIII());
        NPC npcIV = new NPC("НПС IV", "Описание НПС IV", replicasContent.getReplicaForNpcIV());

        npcs.put(npcI.getName().toLowerCase(), npcI);
        npcs.put(npcII.getName().toLowerCase(), npcII);
        npcs.put(npcIII.getName().toLowerCase(), npcIII);
        npcs.put(npcIV.getName().toLowerCase(), npcIV);
    }

    public NPC getNpc(String name) {
        return npcs.get(name.toLowerCase());
    }
}
