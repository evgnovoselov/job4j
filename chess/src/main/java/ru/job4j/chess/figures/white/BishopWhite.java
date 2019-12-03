package ru.job4j.chess.figures.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import java.util.Arrays;

/**
 * Реализация логики светлого слона.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @author Evgeny Novoselov
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException();
        }
        Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
        int deltaX = (dest.x - source.x) < 0 ? -1 : 1;
        int deltaY = (dest.y - source.y) < 0 ? -1 : 1;
        for (int i = 0; i < Math.abs(dest.x - source.x); i++) {
            steps[i] = findStepCell(source.x + (i + 1) * deltaX, source.y + (i + 1) * deltaY);
        }
        return steps;
    }

    private Cell findStepCell(int x, int y) {
        return Arrays.stream(Cell.values())
                .filter(cell -> cell.x == x && cell.y == y)
                .limit(1)
                .findFirst()
                .orElseThrow(ImpossibleMoveException::new);
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
