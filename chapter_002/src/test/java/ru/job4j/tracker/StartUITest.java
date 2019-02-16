package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирования меню пользователя
 *
 * @author Evgeny Novoselov
 */
public class StartUITest {
    /**
     * Метод тестирования добавления новой заявки
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Метод тестирования редактирования заявки
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Метод тестирования удаления заявки
     */
    @Test
    public void whenAddThreeItemsAndOneDeleteThenTrackerHasOneItem() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("test name 1", "description 1")),
                tracker.add(new Item("test name 2", "description 2")),
                tracker.add(new Item("test name 3", "description 3")),
        };
        Input input = new StubInput(new String[]{"3", items[1].getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] expected = {items[0], items[2]};
        assertThat(tracker.findAll(), is(expected));
    }
}
