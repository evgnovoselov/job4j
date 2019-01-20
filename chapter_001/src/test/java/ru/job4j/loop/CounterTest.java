package ru.job4j.loop;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Тестовый класс для Counter
 *
 * @author Evgeny Novoselov
 */
public class CounterTest {
    /**
     * Тестируем метод Counter.add на вычисление суммы четныx чисел в диапазоне от start до finish.
     */
    @Test
    public void whenAddEvenNumbersFrom1to5Then6() {
        Counter counter = new Counter();
        assertThat(
                counter.add(1, 5),
                is(6)
        );
    }
}
