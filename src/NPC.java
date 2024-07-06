import java.util.ArrayList;
import java.util.List;

/**
 * Класс NPC представляет неигрового персонажа
 */
public class NPC {
    private final String name;
    private final String description;
    private final String replica;
    private final List<Item> initialGiftItems;
    private boolean firstMeeting;

    /**
     * Конструктор NPC
     *
     * @param name
     *         Имя NPC
     * @param description
     *         Описание NPC
     * @param replica
     *         Реплика NPC
     */
    public NPC(String name, String description, String replica) {
        this.name = name;
        this.description = description;
        this.replica = replica;
        this.initialGiftItems = new ArrayList<>();
        this.firstMeeting = true;
    }

    /**
     * Возвращает имя NPC
     *
     * @return Имя NPC
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает описание NPC
     *
     * @return Описание NPC
     */
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает реплику NPC
     *
     * @return Реплика NPC
     */
    public String getReplica() {
        return replica;
    }

    /**
     * Добавляет предмет в список начальных подарков NPC
     *
     * @param item
     *         Предмет для добавления
     */
    public void addInitialGiftItem(Item item) {
        initialGiftItems.add(item);
    }

    /**
     * Возвращает список начальных подарков NPC
     *
     * @return Список начальных подарков NPC
     */
    public List<Item> getInitialGiftItems() {
        return initialGiftItems;
    }

    /**
     * Возвращает флаг, указывающий на первое знакомство с NPC
     *
     * @return true, если это первое знакомство, иначе false
     */
    public boolean isFirstMeeting() {
        return firstMeeting;
    }

    /**
     * Устанавливает флаг, указывающий на первое знакомство с NPC
     *
     * @param firstMeeting
     *         Новое значение флага
     */
    public void setFirstMeeting(boolean firstMeeting) {
        this.firstMeeting = firstMeeting;
    }
}
