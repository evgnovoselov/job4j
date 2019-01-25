package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс удаления дублирующих значения их массива
 *
 * @author Evgeny Novoselov
 */
public class ArrayDuplicate {
    /**
     * Метод удаления дублирующих элементов из массива
     *
     * @param array Массив для удаления дублирующих значений
     * @return Возвращает массив уникальных значений
     */
    public String[] remove(String[] array) {
        String[] result = array.clone();
        int duplicate = result.length - 1;
        for (int i = 0; i <= duplicate; i++) {
            for (int j = i + 1; j <= duplicate; j++) {
                if (result[i].equals(result[j])) {
                    String temp = result[j];
                    result[j] = result[duplicate];
                    result[duplicate] = temp;
                    duplicate--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(result, duplicate + 1);
    }
}
