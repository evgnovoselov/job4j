package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса для подсчета функции в диапазоне.
 *
 * @author Evgeny Novoselov
 */
public class DiapasonTest {
    /**
     * Тестирование линейной функции.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Тестирование квадратичной функции.
     */
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(2, 5, x -> 3 * x * x + 2 * x + 1);
        List<Double> expected = Arrays.asList(17D, 34D, 57D);
        assertThat(result, is(expected));
    }

    /**
     * Тестирование логарифмической функции.
     */
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(1, 5, x -> Math.floor(Math.log(x * x) / Math.log(2)));
        List<Double> expected = Arrays.asList(0D, 2D, 3D, 4D);
        assertThat(result, is(expected));
    }
}
