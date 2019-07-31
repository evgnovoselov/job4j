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

    /**
     * Проверка нахождение числа в диапазоне массива.
     */
    @Test
    public void whenArrayHasLength5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int start = 0;
        int finish = 3;
        int result = find.indexOf(input, value, start, finish);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Проверка нахождение числа в диапазоне массива.
     */
    @Test
    public void whenFind3() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = find.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    /**
     * Проверка вывода значения, что число не найдено.
     */
    @Test
    public void whenNoFind() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 5;
        int start = 2;
        int finish = 10;
        int result = find.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

    /**
     * Сортировака с 5 числами.
     */
    @Test
    public void whenSort5() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{3, 4, 1, 2, 5};
        int result[] = find.sort(input);
        int[] expect = new int[]{1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    /**
     * Сортировака с 3 числами.
     */
    @Test
    public void whenSort3() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{3, 4, 1};
        int result[] = find.sort(input);
        int[] expect = new int[]{1, 3, 4};
        assertThat(result, is(expect));
    }
}
