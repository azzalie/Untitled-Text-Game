import java.util.ArrayList;
import java.util.List;

/**
 * Класс ItemConstructor отвечает за создание и хранение предметов в игре
 */
public class ItemConstructor {
    private final List<Item> items;

    /**
     * Конструктор ItemConstructor
     */
    public ItemConstructor() {
        items = new ArrayList<>();
        initializeItems();
    }

    /**
     * Инициализирует список предметов
     */
    private void initializeItems() {
        items.add(new Item("Предмет I", "Предмет первой вершины"));
        items.add(new Item("Предмет II", "Предмет третьей вершины"));
        items.add(new Item("Предмет III", "Предмет четвертой вершины"));
        items.add(new Item("Предмет IV", "Предмет второй вершины"));
    }

    /**
     * Возвращает объект Item по его названию
     *
     * @param name
     *         Название предмета
     *
     * @return Объект Item, если он найден, иначе null
     */
    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Создает новый объект Item с заданным именем
     *
     * @param name
     *         Название предмета
     *
     * @return Новый объект Item
     */
    public Item createItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return new Item(item.getName(), item.getDescription());
            }
        }
        return null;
    }
}
