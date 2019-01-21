package ru.job4j.loop;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Тест класса имитации шахматной доски
 *
 * @author Evgeny Novoselov
 */
public class BoardTest {
    /**
     * Тест представление доски 3 на 3
     */
    @Test
    public void when3x3Board() {
        Board board = new Board();
        String rsl = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)
                )
        );
    }

    /**
     * Тест представление доски 5 на 4
     */
    @Test
    public void when5x4Board() {
        Board board = new Board();
        String rsl = board.paint(5, 4);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln)
                )
        );
    }
}
