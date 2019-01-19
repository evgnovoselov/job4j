package ru.job4j.calculator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test class Calculator
 *
 * @author Evgeny Novoselov
 */
public class CalculatorTest {
    /**
     * Test function calculator.add
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test function calculator.subtract
     */
    @Test
    public void whenSubtract3On2Then1() {
        Calculator calculator = new Calculator();
        calculator.subtract(3D, 2D);
        double result = calculator.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test function calculator.div
     */
    @Test
    public void whenDiv2On2Then1() {
        Calculator calculator = new Calculator();
        calculator.div(2D, 2D);
        double result = calculator.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test function calculator.multiple
     */
    @Test
    public void whenMultiple3On2Then6() {
        Calculator calculator = new Calculator();
        calculator.multiple(3D, 2D);
        double result = calculator.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }
}
