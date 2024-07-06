import java.util.HashMap;
import java.util.Map;

/**
 * Класс LocationConstructor отвечает за создание и хранение локаций в игре
 */
public class LocationConstructor {
    private final Map<String, Location> locations;

    /**
     * Конструктор LocationConstructor
     */
    public LocationConstructor() {
        locations = new HashMap<>();
        initializeLocations();
        LocationRoute.initializeRoutes(this);

        ItemConstructor itemConstructor = new ItemConstructor();
        ItemLocationSetup.setupItems(this, itemConstructor);

        NPCConstructor npcConstructor = new NPCConstructor(itemConstructor);
        NPCLocationSetup.setupNpcs(this, npcConstructor);
    }

    /**
     * Инициализирует список локаций
     */
    private void initializeLocations() {
        Location locationC = new Location("Центр", "Центральная локация");
        Location locationI = new Location("Вершина I", "Первая вершина");
        Location locationII = new Location("Вершина II", "Вторая вершина");
        Location locationIII = new Location("Вершина III", "Третья вершина");
        Location locationIV = new Location("Вершина IV", "Четвертая вершина");

        locations.put(locationC.getName().toLowerCase(), locationC);
        locations.put(locationI.getName().toLowerCase(), locationI);
        locations.put(locationII.getName().toLowerCase(), locationII);
        locations.put(locationIII.getName().toLowerCase(), locationIII);
        locations.put(locationIV.getName().toLowerCase(), locationIV);
    }

    /**
     * Возвращает объект Location по его названию
     *
     * @param name
     *         Название локации
     *
     * @return Объект Location, если он найден, иначе null
     */
    public Location getLocation(String name) {
        return locations.get(name.toLowerCase());
    }
}
