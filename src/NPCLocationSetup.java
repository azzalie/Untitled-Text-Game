public class NPCLocationSetup {
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
