import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<String> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void takeItem(Item item) {
        items.add(item.getName());
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }
}
