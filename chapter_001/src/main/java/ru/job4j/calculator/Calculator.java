package ru.job4j.calculator;

/**
 * This is Calculator class.
 *
 * @author Evgeny Novoselov
 */
public class Calculator {

    private double result;

    /**
     * Get result.
     *
     * @return result
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Sum first and second parameters and save result.
     *
     * @param first  first parameter
     * @param second second parameter
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtraction first and second parameters and save result.
     *
     * @param first  first parameter
     * @param second second parameter
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Division first and second parameters and save result.
     *
     * @param first  first parameter
     * @param second second parameter
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiplication first and second parameters and save result.
     *
     * @param first  first parameter
     * @param second second parameter
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
}
