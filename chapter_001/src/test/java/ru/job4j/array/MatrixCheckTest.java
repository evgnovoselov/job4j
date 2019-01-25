package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирует класс, на проверку, что все элементы по диагоналям равны true или false.
 *
 * @author Evgeny Novoselov
 */
public class MatrixCheckTest {
    /**
     * Тестируем метод MatrixCheck.mono() на матрицу 3*3 с равными диагоналями
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Тестируем метод MatrixCheck.mono() на матрицу 3*3 с неравными диагоналями
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Тестируем метод MatrixCheck.mono() на матрицу 4*4 с равными диагоналями
     */
    @Test
    public void whenDataMonoEvenByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false, false},
                {false, true, false, false},
                {true, false, true, true},
                {false, false, true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Тестируем метод MatrixCheck.mono() на матрицу 5*5 с неравными диагоналями
     */
    @Test
    public void whenDataNotMonoOddByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false, false, true},
                {false, true, false, true, false},
                {true, false, true, true, false},
                {false, true, true, true, false},
                {true, false, true, true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
