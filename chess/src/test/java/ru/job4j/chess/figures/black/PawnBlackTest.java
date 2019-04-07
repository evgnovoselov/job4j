package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем фигуру темной пешки.
 *
 * @author Evgeny Novoselov
 */
public class PawnBlackTest {
    /**
     * Проверяю верное перемещение фигуры.
     */
    @Test
    public void whenCurrentWayThenWay() {
        Cell start = Cell.C7;
        Cell end = Cell.C6;
        Figure figure = new PawnBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }

    /**
     * Проверяю неверное перемещение фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenNotCurrentWayThenNotWay() {
        Cell start = Cell.C7;
        Cell end = Cell.C5;
        Figure figure = new PawnBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }
}
