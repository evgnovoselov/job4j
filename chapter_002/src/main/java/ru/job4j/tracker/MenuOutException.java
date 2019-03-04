package ru.job4j.tracker;

/**
 * Неправильный пункт меню логическая ошибка.
 *
 * @author Evgeny Novoselov
 */
public class MenuOutException extends RuntimeException {
    /**
     * Конструктор ошибки.
     *
     * @param message детальное сообщение.
     */
    public MenuOutException(String message) {
        super(message);
    }
}
