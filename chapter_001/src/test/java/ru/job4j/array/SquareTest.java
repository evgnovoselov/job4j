package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует класс Square возводящий в квадрат элементы массива
 *
 * @author Evgeny Novoselov
 */
public class SquareTest {
    /**
     * Метод тестирует метод Square.calculate с bound 3
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(rst, is(expect));
    }

    /**
     * Метод тестирует метод Square.calculate с bound 5
     */
    @Test
    public void whenBound5Then1491625() {
        int bound = 5;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16, 25};
        assertThat(rst, is(expect));
    }

    /**
     * Метод тестирует метод Square.calculate с bound 8
     */
    @Test
    public void whenBound8Then1491625364964() {
        int bound = 8;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16, 25, 36, 49, 64};
        assertThat(rst, is(expect));
    }
}
