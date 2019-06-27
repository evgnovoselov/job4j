package ru.job4j.list;

import java.util.List;

/**
 * Класс конвертации List в Array.
 *
 * @author Evgeny Novoselov
 */
public class ConvertList2Array {
    /**
     * Метод конвертации колекции List в двуменрный массив.
     *
     * @param list коллекция List.
     * @param rows количество строк.
     * @return двумерный массив равномерно разбимтый на количество строк.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(((double) list.size() + 1) / rows);
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (Integer num : list) {
            array[row][cell] = num;
            cell++;
            if (cell >= array[row].length) {
                row++;
                cell = 0;
            }
        }
        return array;
    }
}
