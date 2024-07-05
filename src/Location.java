import java.util.ArrayList;
import java.util.List;

public class Location {
    private final String name;
    private final String description;
    private final List<Location> neighbors;
    private final List<Item> items;
    private final List<NPC> npcs;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.neighbors = new ArrayList<>();
        this.items = new ArrayList<>();
        this.npcs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Location> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Location neighbor) {
        this.neighbors.add(neighbor);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void addNpc(NPC npc) {
        npcs.add(npc);
    }
}
