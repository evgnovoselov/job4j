package ru.job4j.chess.figures.white;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем фигуру светлой пешки.
 *
 * @author Evgeny Novoselov
 */
public class PawnWhiteTest {
    /**
     * Проверяю верное перемещение фигуры.
     */
    @Test
    public void whenCurrentWayThenWay() {
        Cell start = Cell.B4;
        Cell end = Cell.B5;
        Figure figure = new PawnWhite(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }

    /**
     * Проверяю неверное перемещение фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenNotCurrentWayThenNotWay() {
        Cell start = Cell.B4;
        Cell end = Cell.C5;
        Figure figure = new PawnWhite(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }
}
