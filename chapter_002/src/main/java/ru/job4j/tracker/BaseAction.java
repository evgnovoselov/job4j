package ru.job4j.tracker;

/**
 * Абстрактный класс действий.
 *
 * @author Evgeny Novoselov
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String info;

    protected BaseAction(int key, String info) {
        this.key = key;
        this.info = info;
    }

    /**
     * Метод возвращает ключ опции.
     *
     * @return ключ
     */
    @Override
    public int key() {
        return key;
    }

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню
     */
    @Override
    public String info() {
        return info;
    }
}
