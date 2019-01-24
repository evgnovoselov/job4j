package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс сортировки пузырьком
 *
 * @author Evgeny Novoselov
 */
public class BubbleSortTest {
    /**
     * Метод проверяет сортировку пузырьком
     */
    @Test
    public void whenArrayIntNotSortedThenSorted() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[]{5, 1, 2, 7, 3};
        int[] result = bubbleSort.sort(array);
        assertThat(
                result,
                is(new int[]{1, 2, 3, 5, 7})
        );
    }
}
