package ru.job4j.chess.figures.white;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирую фигуру светлого слона.
 *
 * @author Evgeny Novoselov
 */
public class BishopWhiteTest {
    /**
     * Проверяю верное перемещение фигуры.
     */
    @Test
    public void whenCurrentWayThenWay() {
        Cell start = Cell.D5;
        Cell end = Cell.G2;
        Figure figure = new BishopWhite(start);
        assertThat(figure.way(start, end), is(new Cell[]{Cell.E4, Cell.F3, Cell.G2}));
    }

    /**
     * Проверяю неверное перемещение фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenNotCurrentWayThenNotWay() {
        Cell start = Cell.C8;
        Cell end = Cell.C7;
        Figure figure = new BishopWhite(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }
}
