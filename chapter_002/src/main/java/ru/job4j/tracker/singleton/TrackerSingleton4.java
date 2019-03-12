package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Четвертый вариант singleton, private static final class.
 * Lazy loading.
 *
 * @author Evgeny Novoselov
 */
public class TrackerSingleton4 {
    private TrackerSingleton4() {
    }

    public static TrackerSingleton4 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleton4 INSTANCE = new TrackerSingleton4();
    }

    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}
