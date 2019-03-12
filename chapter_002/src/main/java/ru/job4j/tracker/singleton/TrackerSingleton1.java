package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Первый вариант singleton, enum.
 * Eager loading.
 *
 * @author Evgeny Novoselov
 */
public enum TrackerSingleton1 {
    INSTANCE;

    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}
