public class ItemNPCSetup {
    public static void setupItems(NPCConstructor npcConstructor, ItemConstructor itemConstructor) {
        NPC npcI = npcConstructor.getNpc("НПС I");
        npcI.addInitialGiftItem(itemConstructor.createItem("Предмет I"));
        npcI.addInitialGiftItem(itemConstructor.createItem("Предмет IV"));

        NPC npcII = npcConstructor.getNpc("НПС II");
        npcII.addInitialGiftItem(itemConstructor.createItem("Предмет III"));

        NPC npcIII = npcConstructor.getNpc("НПС III");
        npcIII.addInitialGiftItem(itemConstructor.createItem("Предмет II"));
        npcIII.addInitialGiftItem(itemConstructor.createItem("Предмет IV"));

        NPC npcIV = npcConstructor.getNpc("НПС IV");
        npcIV.addInitialGiftItem(itemConstructor.createItem("Предмет I"));
        npcIV.addInitialGiftItem(itemConstructor.createItem("Предмет I"));
    }
}
