import java.util.ArrayList;
import java.util.List;

/**
 * Класс Location представляет локацию в игре
 */
public class Location {
    private final String name;
    private final String description;
    private final List<Location> neighbors;
    private final List<Item> items;
    private final List<NPC> npcs;

    /**
     * Конструктор Location
     *
     * @param name
     *         Название локации
     * @param description
     *         Описание локации
     */
    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.neighbors = new ArrayList<>();
        this.items = new ArrayList<>();
        this.npcs = new ArrayList<>();
    }

    /**
     * Возвращает название локации
     *
     * @return Название локации
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает описание локации
     *
     * @return Описание локации
     */
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает список соседних локаций
     *
     * @return Список соседних локаций
     */
    public List<Location> getNeighbors() {
        return neighbors;
    }

    /**
     * Добавляет соседнюю локацию
     *
     * @param neighbor
     *         Соседняя локация
     */
    public void addNeighbor(Location neighbor) {
        this.neighbors.add(neighbor);
    }

    /**
     * Возвращает список предметов в локации
     *
     * @return Список предметов в локации
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Добавляет предмет в локацию
     *
     * @param item
     *         Предмет для добавления
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Удаляет предмет из локации
     *
     * @param item
     *         Предмет для удаления
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Возвращает список NPC в локации
     *
     * @return Список NPC в локации
     */
    public List<NPC> getNpcs() {
        return npcs;
    }

    /**
     * Добавляет NPC в локацию
     *
     * @param npc
     *         NPC для добавления
     */
    public void addNpc(NPC npc) {
        npcs.add(npc);
    }
}
