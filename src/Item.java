/**
 * Класс Item представляет предмет в игре
 */
public class Item {
    private final String name;
    private final String description;

    /**
     * Конструктор Item
     *
     * @param name
     *         Название предмета
     * @param description
     *         Описание предмета
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Возвращает название предмета
     *
     * @return Название предмета
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает описание предмета
     *
     * @return Описание предмета
     */
    public String getDescription() {
        return description;
    }
}
