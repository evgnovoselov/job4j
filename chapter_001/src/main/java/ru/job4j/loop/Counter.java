package ru.job4j.loop;

/**
 * Класс Counter.
 *
 * @author Evgeny Novoselov
 */
public class Counter {
    /**
     * Метод должен вычислять сумму четныx чисел в диапазоне от start до finish.
     *
     * @param start  Начальное число
     * @param finish Крнечное число
     * @return Возвращает сумму четных чисел от start до finish
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i < finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
