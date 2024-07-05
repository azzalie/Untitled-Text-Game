import java.util.ArrayList;
import java.util.List;

public class NPC {
    private final String name;
    private final String description;
    private final String replica;
    private final List<Item> initialGiftItems;

    public NPC(String name, String description, String replica) {
        this.name = name;
        this.description = description;
        this.replica = replica;
        this.initialGiftItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getReplica() {
        return replica;
    }

    public void addInitialGiftItem(Item item) {
        initialGiftItems.add(item);
    }

    public List<Item> getInitialGiftItems() {
        return initialGiftItems;
    }
}
