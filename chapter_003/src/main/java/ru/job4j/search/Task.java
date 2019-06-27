package ru.job4j.search;

/**
 * Класс задачи.
 *
 * @author Evgeny Novoselov
 */
public class Task {
    private String desc;
    private int priority;

    /**
     * Конструктор задачи.
     *
     * @param desc     описание задачи.
     * @param priority приоритет задачи.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
