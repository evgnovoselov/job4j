package ru.job4j.array;

/**
 * Класс для сортировки массива пузырьком
 *
 * @author Evgeny Novoselov
 */
public class BubbleSort {
    /**
     * Метод сортирует массив целых чисел, используя алгоритм сортировки пузырьком.
     *
     * @param array Массив целых чисел
     * @return Возвращает отсортированный массив
     */
    public int[] sort(int[] array) {
        int[] resultArray = array.clone();
        boolean checkSort;
        for (int sortElement = 0; sortElement < resultArray.length; sortElement++) {
            checkSort = false;
            for (int i = 0; i < resultArray.length - 1 - sortElement; i++) {
                if (resultArray[i] > resultArray[i + 1]) {
                    checkSort = true;
                    int temp = resultArray[i];
                    resultArray[i] = resultArray[i + 1];
                    resultArray[i + 1] = temp;
                }
            }
            if (!checkSort) {
                break;
            }
        }
        return resultArray;
    }
}
