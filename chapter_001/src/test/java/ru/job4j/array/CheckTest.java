package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс проверки массива на одинаковые boolean значения
 *
 * @author Evgeny Novoselov
 */
public class CheckTest {
    /**
     * Проверяет метод Check.mono() если все значения data[3] true
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Проверяет метод Check.mono() если не все значения data[3] true
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Проверяет метод Check.mono() если все значения data[4] false
     */
    @Test
    public void whenDataMonoByFalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Проверяет метод Check.mono() если не все значения data[5] false
     */
    @Test
    public void whenDataNotMonoByFalseThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}
