/**
 * Класс ItemLocationSetup отвечает за распределение предметов по локациям
 */
public class ItemLocationSetup {
    /**
     * Распределяет предметы по локациям
     *
     * @param locationConstructor
     *         Конструктор локаций
     * @param itemConstructor
     *         Конструктор предметов
     */
    public static void setupItems(LocationConstructor locationConstructor, ItemConstructor itemConstructor) {
        Location locationI = locationConstructor.getLocation("Вершина I");
        locationI.addItem(itemConstructor.createItem("Предмет IV"));

        Location locationII = locationConstructor.getLocation("Вершина II");
        locationII.addItem(itemConstructor.createItem("Предмет II"));

        Location locationIII = locationConstructor.getLocation("Вершина III");
        locationIII.addItem(itemConstructor.createItem("Предмет I"));

        Location locationIV = locationConstructor.getLocation("Вершина IV");
        locationIV.addItem(itemConstructor.createItem("Предмет III"));
    }
}
