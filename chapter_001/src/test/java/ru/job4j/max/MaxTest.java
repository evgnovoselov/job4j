package ru.job4j.max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Тестовый класс нахождения максимума
 */
public class MaxTest {
    /**
     * Тест метода нахождения максимального числа
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Тест метода нахождения максимального числа из 3-х чисел
     */
    @Test
    public void whenFirstLessThirdLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 5, 3);
        assertThat(result, is(5));
    }
}
