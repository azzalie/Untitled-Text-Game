/**
 * Класс Player представляет игрока
 */
public class Player {
    private final Inventory inventory;
    private Location currentLocation;

    /**
     * Конструктор Player
     *
     * @param startingLocation
     *         Начальная локация игрока
     */
    public Player(Location startingLocation) {
        this.currentLocation = startingLocation;
        this.inventory = new Inventory();
    }

    /**
     * Возвращает текущую локацию игрока
     *
     * @return Текущая локация игрока
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Устанавливает текущую локацию игрока
     *
     * @param location
     *         Новая локация игрока
     */
    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    /**
     * Возвращает инвентарь игрока
     *
     * @return Инвентарь игрока
     */
    public Inventory getInventory() {
        return inventory;
    }
}
