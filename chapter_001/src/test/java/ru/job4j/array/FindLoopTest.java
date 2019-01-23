package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования поиска элемента
 *
 * @author Evgeny Novoselov
 */
public class FindLoopTest {
    /**
     * Метод тестирует поиск элемента 5 в массиве
     */
    @Test
    public void whenFindArrayIndexElement5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Метод тестирует не нахождение элемента 7 в массиве
     */
    @Test
    public void whenFindArrayIndexElement7ThenNot() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 7;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
