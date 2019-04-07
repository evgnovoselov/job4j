package ru.job4j.chess.figures.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

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
        Cell[] cells = Cell.values();
        Cell step = null;
        boolean haveStep = false;
        for (Cell cell : cells) {
            if (x == cell.x && y == cell.y) {
                step = cell;
                haveStep = true;
                break;
            }
        }
        if (!haveStep) {
            throw new ImpossibleMoveException();
        }
        return step;
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
