package ru.job4j.loop;

/**
 * Класс считает количество простых чисел от 1 до x.
 *
 * @author Evgeny Novoselov
 */
public class PrimeNumber {
    /**
     * Вычисляем количество простых чисел до finish.
     *
     * @param finish Конечное число.
     * @return Количество простых чисел.
     */
    public int calc(int finish) {
        int count = 0;
        primeLoop:
        for (int i = 2; i <= finish; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue primeLoop;
                }
            }
            count++;
        }
        return count;
    }
}
