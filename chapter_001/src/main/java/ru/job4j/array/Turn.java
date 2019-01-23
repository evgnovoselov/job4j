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
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
