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
        boolean isPut = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                tasks.add(i, task);
                isPut = true;
                break;
            }
        }
        if (!isPut) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
