package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирования матрицы таблицы умножения
 *
 * @author Evgeny Novoselov
 */
public class MatrixTest {
    /**
     * Метод тестирует возврат матрицы с перемноженными индексами размером 2
     */
    @Test
    public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }
}
