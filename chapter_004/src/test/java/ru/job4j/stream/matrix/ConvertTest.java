package ru.job4j.stream.matrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса преобразования.
 *
 * @author Evgeny Novoselov
 */
public class ConvertTest {
    /**
     * Тестирование преобразование из матрицы чисел в список чисел.
     */
    @Test
    public void whenIntegerMatrixConvertToIntegerListThenIntegerList() {
        Integer[][] integers = new Integer[][]{
                new Integer[]{1, 2},
                new Integer[]{3, 4},
        };
        List<Integer> expected = new ArrayList<>();
        for (Integer[] integers1 : integers) {
            expected.addAll(Arrays.asList(integers1));
        }
        List<Integer> result = Convert.toList(integers);
        assertThat(result, is(expected));
    }
}
