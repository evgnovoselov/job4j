package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем фигуру темного короля.
 *
 * @author Evgeny Novoselov
 */
public class KingBlackTest {
    /**
     * Проверяю верное перемещение фигуры по диагонале направо вниз.
     */
    @Test
    public void whenCurrentRightDownWayThenWay() {
        Cell start = Cell.E5;
        Cell end = Cell.F4;
        Figure figure = new KingBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }

    /**
     * Проверяю верное перемещение фигуры по диагонале направо вверх.
     */
    @Test
    public void whenCurrentRightUpWayThenWay() {
        Cell start = Cell.E5;
        Cell end = Cell.F6;
        Figure figure = new KingBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }

    /**
     * Проверяю верное перемещение фигуры направо.
     */
    @Test
    public void whenCurrentRightWayThenWay() {
        Cell start = Cell.E5;
        Cell end = Cell.F5;
        Figure figure = new KingBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }

    /**
     * Проверяю верное перемещение фигуры налево.
     */
    @Test
    public void whenCurrentLeftWayThenWay() {
        Cell start = Cell.E5;
        Cell end = Cell.D5;
        Figure figure = new KingBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }

    /**
     * Проверяю неверное перемещение фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenNotCurrentWayThenNotWay() {
        Cell start = Cell.E5;
        Cell end = Cell.C6;
        Figure figure = new KingBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }
}
