package ru.job4j.chess.figures.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * Реализация логики темного коня (рыцаря).
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @author Evgeny Novoselov
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (Math.abs(dest.x - source.x) + Math.abs(dest.y - source.y) != 3) {
            throw new ImpossibleMoveException();
        }
        if (Math.abs(dest.x - source.x) > 2 || Math.abs(dest.y - source.y) > 2) {
            throw new ImpossibleMoveException();
        }
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
