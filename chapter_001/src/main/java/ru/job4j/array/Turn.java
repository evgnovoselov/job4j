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
        int[] resultArray = array.clone();
        for (int i = 0; i < resultArray.length / 2; i++) {
            int temp = resultArray[i];
            resultArray[i] = resultArray[resultArray.length - i - 1];
            resultArray[resultArray.length - i - 1] = temp;
        }
        return resultArray;
    }
}
