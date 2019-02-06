package ru.job4j.loop;

/**
 * Класс для вычисления факториала.
 *
 * @author Evgeny Novoselov
 */
public class Factorial {
    /**
     * Метод вычисления факториала, до заданного числа.
     *
     * @param n До какого числа считать.
     * @return Возвращаем факториал числа n.
     */
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
