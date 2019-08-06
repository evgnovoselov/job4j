package ru.job4j.tracker.singleton;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование 4 варианта singleton.
 *
 * @author Evgeny Novoselov
 */
public class TrackerSingletonTest {
    /**
     * Массив используется для заполнения заявок в трекер и проверки.
     */
    private Item[] items = {
            new Item("Item 1", "Item 1 Description"),
            new Item("Item 2", "Item 2 Description"),
            new Item("Item 3", "Item 3 Description"),
            new Item("Item 4", "Item 4 Description"),
    };
    /**
     * Коллекция используется для проверки.
     */
    private List<Item> expected = new ArrayList<>(Arrays.asList(items));

    /**
     * Метод тестирует первый вариант singleton.
     * При добавлении заявок в 2 разных трекера полученных через singleton instance,
     * получаем их в одном объекте Трекера.
     */
    @Test
    public void whenGet2TrackersInTrackerSingleton1ThenHave1Tracker() {
        Tracker tracker = TrackerSingleton1.INSTANCE.getTracker();
        Tracker otherTracker = TrackerSingleton1.INSTANCE.getTracker();
        addItemsToTracker(tracker, otherTracker);
        assertThat(tracker.findAll(), is(expected));
    }

    /**
     * Метод тестирует второй вариант singleton.
     * При добавлении заявок в 2 разных трекера полученных через singleton instance,
     * получаем их в одном объекте Трекера.
     */
    @Test
    public void whenGet2TrackersInTrackerSingleton2ThenHave1Tracker() {
        Tracker tracker = TrackerSingleton2.getInstance().getTracker();
        Tracker otherTracker = TrackerSingleton2.getInstance().getTracker();
        addItemsToTracker(tracker, otherTracker);
        assertThat(tracker.findAll(), is(expected));
    }

    /**
     * Метод тестирует третий вариант singleton.
     * При добавлении заявок в 2 разных трекера полученных через singleton instance,
     * получаем их в одном объекте Трекера.
     */
    @Test
    public void whenGet2TrackersInTrackerSingleton3ThenHave1Tracker() {
        Tracker tracker = TrackerSingleton3.getInstance().getTracker();
        Tracker otherTracker = TrackerSingleton3.getInstance().getTracker();
        addItemsToTracker(tracker, otherTracker);
        assertThat(tracker.findAll(), is(expected));
    }

    /**
     * Метод тестирует четвертый вариант singleton.
     * При добавлении заявок в 2 разных трекера полученных через singleton instance,
     * получаем их в одном объекте Трекера.
     */
    @Test
    public void whenGet2TrackersInTrackerSingleton4ThenHave1Tracker() {
        Tracker tracker = TrackerSingleton4.getInstance().getTracker();
        Tracker otherTracker = TrackerSingleton4.getInstance().getTracker();
        addItemsToTracker(tracker, otherTracker);
        assertThat(tracker.findAll(), is(expected));
    }

    /**
     * Метод заполняет разные трекеры заявками.
     *
     * @param tracker      трекер.
     * @param otherTracker другой трекер.
     */
    private void addItemsToTracker(Tracker tracker, Tracker otherTracker) {
        tracker.add(items[0]);
        tracker.add(items[1]);
        otherTracker.add(items[2]);
        otherTracker.add(items[3]);
    }
}
