public class ItemLocationSetup {
    public static void setupItems(LocationConstructor locationConstructor, ItemConstructor itemConstructor) {
        Location locationI = locationConstructor.getLocation("Вершина I");
        locationI.addItem(itemConstructor.createItem("Предмет I"));
        locationI.addItem(itemConstructor.createItem("Предмет IV"));

        Location locationII = locationConstructor.getLocation("Вершина II");
        locationII.addItem(itemConstructor.createItem("Предмет III"));

        Location locationIII = locationConstructor.getLocation("Вершина III");
        locationIII.addItem(itemConstructor.createItem("Предмет II"));
        locationIII.addItem(itemConstructor.createItem("Предмет IV"));

        Location locationIV = locationConstructor.getLocation("Вершина IV");
        locationIV.addItem(itemConstructor.createItem("Предмет I"));
        locationIV.addItem(itemConstructor.createItem("Предмет I"));
    }
}