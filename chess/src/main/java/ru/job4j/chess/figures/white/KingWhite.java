package ru.job4j.chess.figures.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * Реализация логики светлого короля.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @author Evgeny Novoselov
 */
public class KingWhite implements Figure {
    private final Cell position;

    public KingWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (1 < Math.abs(dest.x - source.x) || 1 < Math.abs(dest.y - source.y)) {
            throw new ImpossibleMoveException();
        }
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
