package ru.job4j.array;

/**
 * Класс объединения двух массивов (отсортированных по возрастанию) в третий
 *
 * @author Evgeny Novoselov
 */
public class ArrayMerge {
    /**
     * Метод объединяет два отсортированных массива по возрастанию в третий
     *
     * @param array1
     * @param array2
     * @return Объединенный массив
     */
    public static int[] merge(int[] array1, int[] array2) {
        int maxElements = array1.length + array2.length;
        int[] result = new int[maxElements];
        int indexArray1 = 0;
        int indexArray2 = 0;
        for (int i = 0; i < maxElements; i++) {
            if ((indexArray1 < array1.length) && (indexArray2 < array2.length)) {
                if (array1[indexArray1] < array2[indexArray2]) {
                    result[i] = array1[indexArray1];
                    indexArray1++;
                } else {
                    result[i] = array2[indexArray2];
                    indexArray2++;
                }
            } else if (indexArray1 >= array1.length) {
                result[i] = array2[indexArray2];
                indexArray2++;
            } else {
                result[i] = array1[indexArray1];
                indexArray1++;
            }
        }

        return result;
    }
}
