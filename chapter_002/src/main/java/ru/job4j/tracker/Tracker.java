package ru.job4j.tracker;

import java.util.*;

/**
 * Класс хранилище заявок.
 * Агрегация.
 *
 * @author Evgeny Novoselov
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     *
     * @param item Новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + (new Random()).nextInt());
    }

    /**
     * Метод редактирования заявки в хранилище
     *
     * @param id   Уникальный ключ заявки
     * @param item Заявка
     * @return Успешно ли заявка заменена
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        ListIterator<Item> itemListIterator = this.items.listIterator();
        while (itemListIterator.hasNext()) {
            Item itemNext = itemListIterator.next();
            if (id.equals(itemNext.getId())) {
                itemListIterator.set(item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаления заявки
     *
     * @param id Уникальный ключ заявки
     * @return Успешно ли заявка удалена
     */
    public boolean delete(String id) {
        boolean result = false;
        Iterator<Item> itemIterator = this.items.iterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            if (id.equals(item.getId())) {
                itemIterator.remove();
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод получения списка всех заявок
     *
     * @return Возвращает все заявки в хранище
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод получения списка заявок по имени
     *
     * @param key Ключевое слово в имени заявки
     * @return Возвращает массив заявок
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().contains(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод получения заявки по уникальному ключу
     *
     * @param id Уникальный ключ заявки в хранилище
     * @return Возвращает заявку из хранища
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (id.equals(item.getId())) {
                result = item;
                break;
            }
        }
        return result;
    }
}
