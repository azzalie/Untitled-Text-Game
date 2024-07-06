/**
 * Класс LocationRoute отвечает за установку связей между локациями
 */
public class LocationRoute {
    /**
     * Инициализирует связи между локациями
     *
     * @param locationConstructor
     *         Конструктор локаций
     */
    public static void initializeRoutes(LocationConstructor locationConstructor) {
        Location locationC = locationConstructor.getLocation("Центр");
        Location locationI = locationConstructor.getLocation("Вершина I");
        Location locationII = locationConstructor.getLocation("Вершина II");
        Location locationIII = locationConstructor.getLocation("Вершина III");
        Location locationIV = locationConstructor.getLocation("Вершина IV");

        locationC.addNeighbor(locationI);
        locationC.addNeighbor(locationII);
        locationC.addNeighbor(locationIII);
        locationC.addNeighbor(locationIV);

        locationI.addNeighbor(locationC);
        locationI.addNeighbor(locationII);
        locationI.addNeighbor(locationIV);

        locationII.addNeighbor(locationC);
        locationII.addNeighbor(locationI);
        locationII.addNeighbor(locationIII);

        locationIII.addNeighbor(locationC);
        locationIII.addNeighbor(locationII);
        locationIII.addNeighbor(locationIV);

        locationIV.addNeighbor(locationC);
        locationIV.addNeighbor(locationI);
        locationIV.addNeighbor(locationIII);
    }
}
