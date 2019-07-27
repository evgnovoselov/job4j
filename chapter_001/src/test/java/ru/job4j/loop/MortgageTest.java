package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тестируем класс по ипотеке для верного вычисления количества лет необходимых для погашения кредита.
 *
 * @author Evgeny Novoselov
 */
public class MortgageTest {
    /**
     * Когда 1 год.
     */
    @Test
    public void when1Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.year(1000, 100, 1);
        assertThat(year, is(1));
    }

    /**
     * Когда 2 года.
     */
    @Test
    public void when2Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.year(100, 10, 50);
        assertThat(year, is(2));
    }
}
