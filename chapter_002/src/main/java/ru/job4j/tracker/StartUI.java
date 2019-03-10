package ru.job4j.tracker;

/**
 * Класс взаимодействия с пользователем.
 * Композиция.
 *
 * @author Evgeny Novoselov
 */
public class StartUI {
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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int[] range = menu.getKeyActions();
        do {
            menu.show();
            menu.select(input.ask("Введите пункт меню : ", range));
        } while (!menu.exitProgram);
    }

    /**
     * Запускт программы.
     *
     * @param args Аргументы запуска программы
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
