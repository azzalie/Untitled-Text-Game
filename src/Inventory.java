import java.util.ArrayList;
import java.util.List;

/**
 * Класс Inventory представляет инвентарь игрока
 */
public class Inventory {
    private final List<String> items;

    /**
     * Конструктор Inventory
     */
    public Inventory() {
        this.items = new ArrayList<>();
    }

    /**
     * Удаляет предмет из инвентаря
     *
     * @param item
     *         Название предмета для удаления
     */
    public void removeItem(String item) {
        items.remove(item);
    }

    /**
     * Добавляет предмет в инвентарь
     *
     * @param item
     *         Предмет, который нужно добавить
     */
    public void takeItem(Item item) {
        items.add(item.getName());
    }

    /**
     * Возвращает список предметов в инвентаре
     *
     * @return Список предметов в инвентаре
     */
    public List<String> getItems() {
        return new ArrayList<>(items);
    }
}
