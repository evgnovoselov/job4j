package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирования меню пользователя
 *
 * @author Evgeny Novoselov
 */
public class StartUITest {
    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final String nl = System.lineSeparator();

    private final String menuTemplate = new StringBuilder()
            .append("Меню.").append(this.nl)
            .append("0. Добавление новой заявки").append(this.nl)
            .append("1. Отображение списка всех заявок").append(this.nl)
            .append("2. Редактирование заявки").append(this.nl)
            .append("3. Удаление заявки").append(this.nl)
            .append("4. Поиск заявки по уникальному номеру").append(this.nl)
            .append("5. Поиск заявок по имени").append(this.nl)
            .append("6. Выход из программы").append(this.nl).append(this.nl)
            .toString();

    /**
     * Метод заменяет стандартный вывод на вывод в пямять для тестирования.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Метод возвращает обратно стандартный вывод в консоль.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Метод тестирования добавления новой заявки
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
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

    /**
     * Метод тестирования отображение списка всех заявок
     */
    @Test
    public void whenShowAllItems() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("test name 1", "description 1")),
                tracker.add(new Item("test name 2", "description 2")),
        };
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(this.menuTemplate)
                        .append("--------------------------------").append(this.nl)
                        .append("Вывод всех заявок:").append(this.nl)
                        .append("--------------------------------").append(this.nl)
                        .append("Найдено заявок: 2").append(this.nl)
                        .append("Item{id='").append(items[0].getId()).append("', name='test name 1', description='description 1', created=").append(items[0].getCreated()).append(", comments=null}").append(this.nl)
                        .append("Item{id='").append(items[1].getId()).append("', name='test name 2', description='description 2', created=").append(items[1].getCreated()).append(", comments=null}").append(this.nl)
                        .append("--------------------------------").append(this.nl)
                        .append(this.menuTemplate)
                        .toString())
        );
    }

    /**
     * Метод тестирования отображение заявки по уникальному номеру
     */
    @Test
    public void whenItemFindById() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("test name 1", "description 1")),
                tracker.add(new Item("test name 2", "description 2")),
                tracker.add(new Item("test name 3", "description 3")),
        };
        Input input = new StubInput(new String[]{"4", items[1].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(this.menuTemplate)
                        .append("--------------------------------").append(this.nl)
                        .append("Поиск заявки по уникальному номеру:").append(this.nl)
                        .append("--------------------------------").append(this.nl)
                        .append("Найдено заявок: 1").append(this.nl)
                        .append("Item{id='").append(items[1].getId()).append("', name='test name 2', description='description 2', created=").append(items[1].getCreated()).append(", comments=null}").append(this.nl)
                        .append("--------------------------------").append(this.nl)
                        .append(this.menuTemplate)
                        .toString())
        );
    }

    /**
     * Метод тестирования отображение заявки по уникальному номеру
     */
    @Test
    public void whenItemsFindByName() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("nice name 1", "description 1")),
                tracker.add(new Item("bad name 2", "description 2")),
                tracker.add(new Item("nice name 3", "description 3")),
        };
        Input input = new StubInput(new String[]{"5", "nice", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(this.menuTemplate)
                        .append("--------------------------------").append(this.nl)
                        .append("Поиск заявок по имени:").append(this.nl)
                        .append("--------------------------------").append(this.nl)
                        .append("Найдено заявок: 2").append(this.nl)
                        .append("Item{id='").append(items[0].getId()).append("', name='nice name 1', description='description 1', created=").append(items[0].getCreated()).append(", comments=null}").append(this.nl)
                        .append("Item{id='").append(items[2].getId()).append("', name='nice name 3', description='description 3', created=").append(items[2].getCreated()).append(", comments=null}").append(this.nl)
                        .append("--------------------------------").append(this.nl)
                        .append(this.menuTemplate)
                        .toString())
        );
    }
}
