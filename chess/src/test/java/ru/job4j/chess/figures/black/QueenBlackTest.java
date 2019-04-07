package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем фигуру темного ферзя.
 *
 * @author Evgeny Novoselov
 */
public class QueenBlackTest {
    /**
     * Проверяю верное перемещение фигуры.
     */
    @Test
    public void whenCurrentWayThenWay() {
        Cell start = Cell.D4;
        Cell end = Cell.G7;
        Figure figure = new QueenBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{Cell.E5, Cell.F6, Cell.G7}));
    }

    /**
     * Проверяю верное перемещение фигуры налево.
     */
    @Test
    public void whenCurrentLeftWayThenWay() {
        Cell start = Cell.D4;
        Cell end = Cell.A4;
        Figure figure = new QueenBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{Cell.C4, Cell.B4, Cell.A4}));
    }

    /**
     * Проверяю верное перемещение фигуры направо.
     */
    @Test
    public void whenCurrentRightWayThenWay() {
        Cell start = Cell.D4;
        Cell end = Cell.H4;
        Figure figure = new QueenBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{Cell.E4, Cell.F4, Cell.G4, Cell.H4}));
    }

    /**
     * Проверяю верное перемещение фигуры наверх.
     */
    @Test
    public void whenCurrentUpWayThenWay() {
        Cell start = Cell.D4;
        Cell end = Cell.D8;
        Figure figure = new QueenBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{Cell.D5, Cell.D6, Cell.D7, Cell.D8}));
    }

    /**
     * Проверяю верное перемещение фигуры вниз.
     */
    @Test
    public void whenCurrentDownWayThenWay() {
        Cell start = Cell.D4;
        Cell end = Cell.D1;
        Figure figure = new QueenBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{Cell.D3, Cell.D2, Cell.D1}));
    }

    /**
     * Проверяю неверное перемещение фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenNotCurrentWayThenNotWay() {
        Cell start = Cell.D4;
        Cell end = Cell.A3;
        Figure figure = new QueenBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }
}
