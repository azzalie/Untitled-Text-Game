import java.util.ArrayList;
import java.util.List;

public class ItemConstructor {
    private final List<Item> items;

    public ItemConstructor() {
        items = new ArrayList<>();
        initializeItems();
    }

    private void initializeItems() {
        items.add(new Item("Предмет I", "Предмет первой вершины"));
        items.add(new Item("Предмет II", "Предмет третьей вершины"));
        items.add(new Item("Предмет III", "Предмет четвертой вершины"));
        items.add(new Item("Предмет IV", "Предмет второй вершины"));
    }

    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public Item createItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return new Item(item.getName(), item.getDescription());
            }
        }
        return null;
    }
}
