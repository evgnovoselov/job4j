package ru.job4j.loop;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Класс для проверки класса факториала
 *
 * @author Evgeny Novoselov
 */
public class FactorialTest {
    /**
     * Метод проверяет Факториал для числа 5 будет равен 120 (1 * 2 * 3 * 4 * 5).
     */
    @Test
    public void whenFactorialCalc5Then120() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calc(5), is(120));
    }

    /**
     * Метод проверяет Факториал для числа 0 равен 1.
     */
    @Test
    public void whenFactorialCalc0Then11() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calc(0), is(1));
    }
}
