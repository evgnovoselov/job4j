package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем фигуру темной ладьи.
 *
 * @author Evgeny Novoselov
 */
public class RookBlackTest {
    /**
     * Проверяю верное перемещение фигуры вправо.
     */
    @Test
    public void whenCurrentRightWayThenWay() {
        Cell start = Cell.D5;
        Cell end = Cell.H5;
        Figure figure = new RookBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{Cell.E5, Cell.F5, Cell.G5, Cell.H5}));
    }

    /**
     * Проверяю верное перемещение фигуры вверх.
     */
    @Test
    public void whenCurrentUpWayThenWay() {
        Cell start = Cell.D5;
        Cell end = Cell.D8;
        Figure figure = new RookBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{Cell.D6, Cell.D7, Cell.D8}));
    }

    /**
     * Проверяю неверное перемещение фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenNotCurrentWayThenNotWay() {
        Cell start = Cell.D4;
        Cell end = Cell.A3;
        Figure figure = new RookBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }
}
