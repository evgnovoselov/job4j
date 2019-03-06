package ru.job4j.tracker;

/**
 * Интерфейс ввода.
 *
 * @author Evgeny Novoselov
 */
public interface Input {
    /**
     * Метод задает вопрос и возвращает ответ
     *
     * @param question вопрос.
     * @return ответ.
     */
    String ask(String question);

    /**
     * Метод задает вопрос и возвращает ответ.
     *
     * @param question вопрос.
     * @param range    возможный ответ.
     * @return возвращает введенный ответ.
     */
    int ask(String question, int[] range);
}
