package ru.job4j.array;

/**
 * Класс для переворота массива
 *
 * @author Evgeny Novoselov
 */
public class Turn {
    /**
     * Метод переварачивает массив
     *
     * @param array Исходный массив для разварота
     * @return Возвращает развернутый массив
     */
    public int[] back(int[] array) {
        int[] revers = array.clone();
        for (int i = 0; i < revers.length / 2; i++) {
            int temp = revers[i];
            revers[i] = revers[revers.length - i - 1];
            revers[revers.length - i - 1] = temp;
        }
        return revers;
    }
}
