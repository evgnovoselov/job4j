package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тестирование класса нахождения количества простых чисел от 1 до x
 *
 * @author Evgeny Novoselov
 */
public class PrimeNumberTest {
    /**
     * Тестирование нахождения количество простых чисел с 1 до 5.
     */
    @Test
    public void when5() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(5);
        assertThat(count, is(3));
    }

    /**
     * Тестирование нахождения количество простых чисел с 1 до 11.
     */
    @Test
    public void when11() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(11);
        assertThat(count, is(5));
    }

    /**
     * Тестирование нахождения количество простых чисел с 1 до 2.
     */
    @Test
    public void when2() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(2);
        assertThat(count, is(1));
    }

    /**
     * Тестирование нахождения количество простых чисел с 1 до 1.
     */
    @Test
    public void when1() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(1);
        assertThat(count, is(0));
    }
}
