package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс реализует меню трекера.
 * Агрегация.
 *
 * @author Evgeny Novoselov
 */
public class MenuTracker {
    public boolean exitProgram = false;
    /**
     * Хранит ссылку на объект.
     */
    private Input input;
    /**
     * Хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * Хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Функциональный интерфейс для вывода данных.
     */
    private final Consumer<String> output;

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     * @param output  вывод данных.
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод возвращает существующие ключи действий.
     *
     * @return массив ключей операций
     */
    public int[] getKeyActions() {
        int[] keys = new int[this.actions.size()];
        for (int i = 0; i < this.actions.size(); i++) {
            keys[i] = this.actions.get(i).key();
        }
        return keys;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавление новой заявки"));
        this.actions.add(new ShowItems(1, "Отображение списка всех заявок"));
        this.actions.add(new UpdateItem(2, "Редактирование заявки"));
        this.actions.add(new DeleteItem(3, "Удаление заявки"));
        this.actions.add(new FindItemById(4, "Поиск заявки по уникальному номеру"));
        this.actions.add(new FindItemsByName(5, "Поиск заявок по имени"));
        this.actions.add(new ExitProgram(6, "Выход из программы"));

    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        for (UserAction action : this.actions) {
            if (key == action.key()) {
                action.execute(this.input, this.tracker);
                break;
            }
        }
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        output.accept("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.key() + ". " + action.info());
            }
        }
        output.accept("");
    }

    /**
     * Метод печатает массив заявок
     *
     * @param items Массив заявок
     */
    private void printItems(List<Item> items) {
        output.accept("--------------------------------");
        output.accept("Найдено заявок: " + items.size());
        for (Item item : items) {
            output.accept(item.toString());
        }
        output.accept("--------------------------------");
    }

    /**
     * Метод спрашивает и ищет заявку
     *
     * @return Возвращает найденную заявку
     */
    private Item askFindByIdItem() {
        Item item = this.tracker.findById(this.input.ask("Введите уникальный номер заявки: "));
        if (item == null) {
            output.accept("--------------------------------"
                    + System.lineSeparator() + "Ошибка, данная заявка не найдена"
                    + System.lineSeparator() + "--------------------------------");
            return null;
        }
        return item;
    }

    /**
     * Вложенный класс действия добавления заявки.
     * Наследование.
     */
    private class AddItem extends BaseAction {
        public AddItem(int key, String info) {
            super(key, info);
        }

        /**
         * Основной метод.
         *
         * @param input   объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ Новая заявка с Id : " + item.getId() + " -----------");
            output.accept("Name : " + item.getName());
            output.accept("Description : " + item.getDescription());
            output.accept("--------------------------------");
        }
    }

    /**
     * Вложенный класс действия выхода из программы.
     * Наследвание.
     */
    private class ExitProgram extends BaseAction {
        public ExitProgram(int key, String info) {
            super(key, info);
        }

        /**
         * Основной метод.
         *
         * @param input   объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            exitProgram = true;
        }
    }

    /**
     * Вложенный класс действия просмотра всез заявок.
     * Наследования.
     */
    private class ShowItems extends BaseAction {
        public ShowItems(int key, String info) {
            super(key, info);
        }

        /**
         * Основной метод.
         *
         * @param input   объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("--------------------------------");
            output.accept("Вывод всех заявок:");
            List<Item> items = tracker.findAll();
            printItems(items);
        }
    }

    /**
     * Вложенный класс действия обновления заявки.
     * Наследование.
     */
    private class UpdateItem extends BaseAction {
        public UpdateItem(int key, String info) {
            super(key, info);
        }

        /**
         * Основной метод.
         *
         * @param input   объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("--------------------------------");
            output.accept("Редактирование заявки");
            Item previous = askFindByIdItem();
            if (previous == null) {
                return;
            }
            String name;
            String description;
            output.accept("--------------------------------"
                    + System.lineSeparator() + "Найденная заявка: "
                    + System.lineSeparator() + "Уникальный номер: " + previous.getId()
                    + System.lineSeparator() + "Имя заявки: " + previous.getName()
                    + System.lineSeparator() + "--------------------------------");
            name = input.ask("Введите новое имя заявки:");
            output.accept("--------------------------------"
                    + System.lineSeparator() + "Описание заявки: " + previous.getDescription()
                    + System.lineSeparator() + "--------------------------------");
            description = input.ask("Введите новое описание заявки:");
            output.accept("--------------------------------");
            Item next = new Item(name, description);
            next.setId(previous.getId());
            tracker.replace(previous.getId(), next);
        }
    }

    /**
     * Вложенный класс действия удаления заявки.
     * Наследование.
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String info) {
            super(key, info);
        }

        /**
         * Основной метод.
         *
         * @param input   объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("--------------------------------");
            output.accept("Удаление заявки");
            String id = input.ask("Введите уникальный номер заявки: ");
            output.accept(tracker.delete(id) ? "Заявка успешно удалена" : "Ошибка удаления заявки");
            output.accept("--------------------------------");
        }
    }

    /**
     * Вложенный клас действия нахождения заявки по уникальному номеру.
     * Наследование.
     */
    private class FindItemById extends BaseAction {
        public FindItemById(int key, String info) {
            super(key, info);
        }

        /**
         * Основной метод.
         *
         * @param input   объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("--------------------------------");
            output.accept("Поиск заявки по уникальному номеру:");
            Item item = askFindByIdItem();
            if (item == null) {
                return;
            }
            List<Item> items = new ArrayList<>();
            items.add(item);
            printItems(items);
        }
    }

    /**
     * Вложенный класс действия нахождения заявок по имени.
     * Наследование.
     */
    private class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String info) {
            super(key, info);
        }

        /**
         * Основной метод.
         *
         * @param input   объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("--------------------------------");
            output.accept("Поиск заявок по имени:");
            List<Item> items = tracker.findByName(input.ask("Введите имя заявки: "));
            printItems(items);
        }
    }
}
