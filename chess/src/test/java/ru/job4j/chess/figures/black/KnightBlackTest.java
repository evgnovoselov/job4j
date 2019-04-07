package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем фигуру темного коня (рыцаря).
 *
 * @author Evgeny Novoselov
 */
public class KnightBlackTest {
    /**
     * Проверяю верное перемещение фигуры.
     */
    @Test
    public void whenCurrentWayThenWay() {
        Cell start = Cell.E5;
        Cell end = Cell.C6;
        Figure figure = new KnightBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }

    /**
     * Проверяю неверное перемещение фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenNotCurrentWayThenNotWay() {
        Cell start = Cell.E5;
        Cell end = Cell.E2;
        Figure figure = new KnightBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }
}
