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
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище.
     *
     * @param item Новая заявка
     */
    public Item add(Item item) {
        //TODO почистить
        /*item.setId(this.generateId());
        this.items[this.position++] = item;*/
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
        //TODO почистить
        boolean result = false;
        /*for (int i = 0; i < position; i++) {
            if (id.equals(this.items[i].getId())) {
                this.items[i] = item;
                result = true;
                break;
            }
        }*/
        return result;
    }

    /**
     * Метод удаления заявки
     *
     * @param id Уникальный ключ заявки
     * @return Успешно ли заявка удалена
     */
    public boolean delete(String id) {
        //TODO почистить
        boolean result = false;
        /*if (this.position > 0) {
            for (int i = 0; i < this.position; i++) {
                if (id.equals(this.items[i].getId())) {
                    System.arraycopy(this.items, i + 1, this.items, i, this.items.length - 1 - i);
                    this.items[--this.position] = null;
                    result = true;
                    break;
                }
            }
        }*/
        return result;
    }

    /**
     * Метод получения списка всех заявок
     *
     * @return Возвращает все заявки в хранище
     */
    public List<Item> findAll() {
        //TODO почистить
        //return Arrays.copyOf(this.items, this.position);
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
        //TODO почистить
        Item result = null;
        /*for (int i = 0; i < position; i++) {
            if (id.equals(this.items[i].getId())) {
                result = this.items[i];
                break;
            }
        }*/
        return result;
    }
}
