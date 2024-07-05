public class NPC {
    private final String name;
    private final String description;
    private final String replica;

    public NPC(String name, String description, String replica) {
        this.name = name;
        this.description = description;
        this.replica = replica;
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
}
