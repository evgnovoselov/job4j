package ru.job4j.max;

/**
 * Класс нахождения максимума.
 *
 * @author Evgeny Novoselov
 */
public class Max {
    /**
     * Метод нахождения максимального числа.
     *
     * @param first  Первое число
     * @param second Второе число
     * @return Возвращаем максимальное число
     */
    public int max(int first, int second) {
        return (first >= second) ? first : second;
    }
}
