package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов хранилища заявок
 *
 * @author Evgeny Novoselov
 */
public class TrackerTest {
    /**
     * Метод тестирует создание заявки в хранилище.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    /**
     * Метод тестирует замену заявки в хранилище
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тестирование метода удаления заявки из хранилища
     */
    @Test
    public void whenDeleteItemInTrackerThenNoHaveItem() {
        Tracker tracker = new Tracker();
        Item[] items = {
                new Item("test1", "testDescription1", 101L),
                new Item("test2", "testDescription2", 102L),
                new Item("test3", "testDescription3", 103L),
                new Item("test4", "testDescription4", 104L),
                new Item("test5", "testDescription5", 105L),
        };
        for (Item item : items) {
            tracker.add(item);
        }
        tracker.delete(items[1].getId()); // delete test2
        tracker.delete(items[3].getId()); // delete test4
        List<Item> expected = new ArrayList<>();
        expected.add(items[0]);
        expected.add(items[2]);
        expected.add(items[4]);
        assertThat(tracker.findAll(), is(expected));
    }

    /**
     * Тестирование метода получения всех заявок из хранилища
     */
    @Test
    public void whenAddThreeItemsInTrackerThenGetThreeItems() {
        Tracker tracker = new Tracker();
        Item[] items = {
                new Item("test1", "testDescription1", 101L),
                new Item("test2", "testDescription2", 102L),
                new Item("test3", "testDescription3", 103L),
        };
        for (Item item : items) {
            tracker.add(item);
        }
        List<Item> expected = new ArrayList<>(Arrays.asList(items));
        assertThat(tracker.findAll(), is(expected));
    }

    /**
     * Тестирование метода поиска заявок в хранилище по ключевому слову в имени
     */
    @Test
    public void whenFindByNameItemsThenFindThem() {
        Tracker tracker = new Tracker();
        Item[] items = {
                new Item("test1", "testDescription1", 101L),
                new Item("dont2", "testDescription2", 102L),
                new Item("test3", "testDescription3", 103L),
                new Item("dont4", "testDescription3", 103L),
                new Item("test5", "testDescription3", 103L),
        };
        for (Item item : items) {
            tracker.add(item);
        }
        List<Item> expectedNames = new ArrayList<>();
        expectedNames.add(items[0]);
        expectedNames.add(items[2]);
        expectedNames.add(items[4]);
        assertThat(tracker.findByName("test"), is(expectedNames));
    }

    /**
     * Тестирование метода поиска заявки в хранилище по уникальному номеру
     */
    @Test
    public void whenFindByIdItemThenFindHim() {
        Tracker tracker = new Tracker();
        Item[] items = {
                new Item("test1", "testDescription1", 101L),
                new Item("test2", "testDescription2", 102L),
                new Item("test3", "testDescription3", 103L),
        };
        for (Item item : items) {
            tracker.add(item);
        }
        assertThat(tracker.findById(items[1].getId()), is(items[1]));
    }
}
