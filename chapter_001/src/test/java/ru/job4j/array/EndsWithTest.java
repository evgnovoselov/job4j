package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование метода по проверке постфикса.
 *
 * @author Evgeny Novoselov
 */
public class EndsWithTest {
    /**
     * Проверка верного постфикса.
     */
    @Test
    public void whenEndWithPostfixThenTrue() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "lo");
        assertThat(result, is(true));
    }

    /**
     * Проверка не верного постфикса.
     */
    @Test
    public void whenNotEndWithPostfixThenFalse() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "la");
        assertThat(result, is(false));
    }

    /**
     * Проверка частного случая когда постфикс больше слова.
     */
    @Test
    public void whenNotEndWithPostfixThenFalse2() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "HHello");
        assertThat(result, is(false));
    }
}
