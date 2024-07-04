public class Player {
    private final Inventory inventory;
    private Location currentLocation;

    public Player(Location startingLocation) {
        this.currentLocation = startingLocation;
        this.inventory = new Inventory();
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
