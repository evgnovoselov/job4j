package ru.job4j.array;

/**
 * Класс создает Матрицу элементов таблицы умножения по размеру
 *
 * @author Evgeny Novoselov
 */
public class Matrix {
    /**
     * Метод возвращает матрицу эдементов таблицы умножения
     *
     * @param size Размер матрицы
     * @return Возвращает матрицу с перемноженными элементами
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
