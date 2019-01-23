package ru.job4j.array;

/**
 * Класс площадь
 *
 * @author Evgeny Novoselov
 */
public class Square {
    /**
     * Метод возводит кадвый элемент массива в квадрат.
     *
     * @param bound Размер массива.
     * @return Возвращает массив, каждый элемент которого возведен в квадрат.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}
