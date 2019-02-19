package ru.job4j.tracker;

/**
 * Класс взаимодействия с пользователем.
 *
 * @author Evgeny Novoselov
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для отображения списка всех заявок
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа меню для редактирования заявки
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаление заявки
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по уникальному номеру
     */
    private static final String FIND_BY_ID = "4";

    /**
     * Константа меню для поиска заявок по имени
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    private final String nl = System.lineSeparator();

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW_ALL:
                    this.showAllItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FIND_BY_ID:
                    this.showByIdItem();
                    break;
                case FIND_BY_NAME:
                    this.showByNameItems();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    this.defaultAction();
                    break;
            }
        }
    }

    /**
     * Неизвестный ввод пользователя
     */
    private void defaultAction() {
        System.out.println("--------------------------------");
        System.out.println("¯\\_(ツ)_/¯ Вы ввели что-то не то.\nПопробуйте еще раз :)");
        System.out.println("--------------------------------");
    }

    /**
     * Метод поиск заявок по имени
     */
    private void showByNameItems() {
        System.out.println("--------------------------------");
        System.out.println("Поиск заявок по имени:");
        Item[] items = this.tracker.findByName(this.input.ask("Введите имя заявки: "));
        this.printItems(items);
    }

    /**
     * Метод поиск заявки по уникальному номеру
     */
    private void showByIdItem() {
        System.out.println("--------------------------------");
        System.out.println("Поиск заявки по уникальному номеру:");
        Item item = this.askFindByIdItem();
        if (item == null) {
            return;
        }
        this.printItems(new Item[]{item});
    }

    /**
     * Метод удаление заявки
     */
    private void deleteItem() {
        System.out.println("--------------------------------");
        System.out.println("Удаление заявки");
        Item item = this.askFindByIdItem();
        if (item == null) {
            return;
        }
        System.out.println(this.tracker.delete(item.getId()) ? "Заявка успешно удалена" : "Ошибка удаления заявки");
        System.out.println("--------------------------------");
    }

    /**
     * Метод редактирование заявки
     */
    private void editItem() {
        System.out.println("--------------------------------");
        System.out.println("Редактирование заявки");
        Item item = this.askFindByIdItem();
        if (item == null) {
            return;
        }
        System.out.println("--------------------------------"
                + "\nНайденная заявка: "
                + "\nУникальный номер: " + item.getId()
                + "\nИмя заявки: " + item.getName()
                + "\n--------------------------------");
        item.setName(this.input.ask("Введите новое имя заявки:"));
        System.out.println("--------------------------------"
                + "\nОписание заявки: " + item.getDescription()
                + "\n--------------------------------");
        item.setDescription(this.input.ask("Введите новое описание заявки:"));
        System.out.println("--------------------------------");
    }

    /**
     * Метод спрашивает и ищет заявку
     *
     * @return Возвращает найденную заявку
     */
    private Item askFindByIdItem() {
        Item item = this.tracker.findById(this.input.ask("Введите уникальный номер заявки: "));
        if (item == null) {
            System.out.println("--------------------------------"
                    + "\nОшибка, данная заявка не найдена"
                    + "\n--------------------------------");
            return null;
        }
        return item;
    }

    /**
     * Метод печатает массив заявок
     *
     * @param items Массив заявок
     */
    private void printItems(Item[] items) {
        System.out.println("--------------------------------");
        System.out.println("Найдено заявок: " + items.length);
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("--------------------------------");

    }

    /**
     * Метод отображение списка всех заявок
     */
    private void showAllItems() {
        System.out.println("--------------------------------");
        System.out.println("Вывод всех заявок:");
        Item[] items = this.tracker.findAll();
        this.printItems(items);
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + " -----------");
    }

    /**
     * Выводим меню
     */
    private void showMenu() {
        System.out.println(
                new StringBuilder()
                        .append("Меню.").append(this.nl)
                        .append(ADD).append(". Добавление новой заявки").append(this.nl)
                        .append(SHOW_ALL).append(". Отображение списка всех заявок").append(this.nl)
                        .append(EDIT).append(". Редактирование заявки").append(this.nl)
                        .append(DELETE).append(". Удаление заявки").append(this.nl)
                        .append(FIND_BY_ID).append(". Поиск заявки по уникальному номеру").append(this.nl)
                        .append(FIND_BY_NAME).append(". Поиск заявок по имени").append(this.nl)
                        .append(EXIT).append(". Выход из программы").append(this.nl)
        );
    }

    /**
     * Запускт программы.
     *
     * @param args Аргументы запуска программы
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
