package ru.job4j.search;

import java.util.LinkedList;

/**
 * Класс агрегирует объекты задач по приоритету.
 *
 * @author Evgeny Novoselov
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставляет в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки используется add(int index, E value).
     *
     * @param task задача.
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
    }

    public Task take() {
        return this.tasks.poll();
    }
}
