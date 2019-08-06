package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        for (int i = 0; i < this.items.size(); i++) {
            if (id.equals(this.items.get(i).getId())) {
                this.items.set(i, item);
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
        for (int i = 0; i < this.items.size(); i++) {
            if (id.equals(this.items.get(i).getId())) {
                this.items.remove(i);
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
        //TODO почистить
        /*int count = 0;
        Item[] result = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().contains(key)) {
                result[count++] = this.items[i];
            }
        }
        return Arrays.copyOf(result, count);*/
        return new ArrayList<>();
    }

    /**
     * Метод получения заявки по уникальному ключу
     *
     * @param id Уникальный ключ заявки в хранилище
     * @return Возвращает заявку из хранища
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.items.size(); i++) {
            if (id.equals(this.items.get(i).getId())) {
                result = this.items.get(i);
                break;
            }
        }
        return result;
    }
}
