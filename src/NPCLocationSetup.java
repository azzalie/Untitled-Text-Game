/**
 * Класс NPCLocationSetup отвечает за распределение NPC по локациям
 */
public class NPCLocationSetup {
    /**
     * Распределяет NPC по локациям
     *
     * @param locationConstructor
     *         Конструктор локаций
     * @param npcConstructor
     *         Конструктор NPC
     */
    public static void setupNpcs(LocationConstructor locationConstructor,
                                 NPCConstructor npcConstructor) {
        Location locationI = locationConstructor.getLocation("Вершина I");
        locationI.addNpc(npcConstructor.getNpc("НПС I"));

        Location locationII = locationConstructor.getLocation("Вершина II");
        locationII.addNpc(npcConstructor.getNpc("НПС II"));

        Location locationIII = locationConstructor.getLocation("Вершина III");
        locationIII.addNpc(npcConstructor.getNpc("НПС III"));

        Location locationIV = locationConstructor.getLocation("Вершина IV");
        locationIV.addNpc(npcConstructor.getNpc("НПС IV"));
    }
}
