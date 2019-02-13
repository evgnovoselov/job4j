package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс хранилище заявок.
 *
 * @author Evgeny Novoselov
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище.
     *
     * @param item Новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int i = 0; i < position; i++) {
            if (id.equals(this.items[i].getId())) {
                this.items[i] = item;
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
        if (this.position > 0) {
            for (int i = 0; i < this.position; i++) {
                if (id.equals(this.items[i].getId())) {
                    System.arraycopy(this.items, i + 1, this.items, i, this.items.length - 1 - i);
                    this.items[--this.position] = null;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод получения списка всех заявок
     *
     * @return Возвращает все заявки в хранище
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод получения списка заявок по имени
     *
     * @param key Ключевое слово в имени заявки
     * @return Возвращает массив заявок
     */
    public Item[] findByName(String key) {
        int count = 0;
        Item[] result = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().contains(key)) {
                result[count++] = this.items[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Метод получения заявки по уникальному ключу
     *
     * @param id Уникальный ключ заявки в хранилище
     * @return Возвращает заявку из хранища
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (id.equals(this.items[i].getId())) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }
}
