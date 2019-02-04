package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса с методом объединения 2-х массивов в 3-ий
 *
 * @author Evgeny Novoselov
 */
public class ArrayMergeTest {
    /**
     * Тест метода объединения 2-ух отсортированных масивов по возрастанию в 3-ий
     */
    @Test
    public void when2ArraysSortedThenMergeSortedArray() {
        int[] array1 = new int[]{1, 3, 4, 6, 8};
        int[] array2 = new int[]{2, 3, 5, 6, 7, 9};
        int[] result = ArrayMerge.merge(array1, array2);
        assertThat(
                result,
                is(new int[]{1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9})
        );
    }
}
