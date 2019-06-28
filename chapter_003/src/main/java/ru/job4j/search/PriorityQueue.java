package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

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
        ListIterator<Task> taskListIterator = tasks.listIterator();
        while (taskListIterator.hasNext()) {
            Task nextTask = taskListIterator.next();
            if (task.getPriority() <= nextTask.getPriority()) {
                taskListIterator.previous();
                taskListIterator.add(task);
                isPut = true;
                break;
            }
        }
        if (!isPut) {
            taskListIterator.add(task);
        }
    }

    /**
     * Метод возвращает задачу и удаляет её из коллекции.
     *
     * @return задачу.
     */
    public Task take() {
        return this.tasks.poll();
    }
}
