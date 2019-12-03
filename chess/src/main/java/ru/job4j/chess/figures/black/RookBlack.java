package ru.job4j.chess.figures.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import java.util.Arrays;

/**
 * Реализация логики темной ладьи.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @author Evgeny Novoselov
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (Math.abs(dest.x - source.x) != 0 && Math.abs(dest.y - source.y) != 0) {
            throw new ImpossibleMoveException();
        }
        int sizeSteps = Math.abs(dest.x - source.x) > 0 ? Math.abs(dest.x - source.x) : Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[sizeSteps];
        int deltaX = 0;
        if ((dest.x - source.x) != 0) {
            deltaX = (dest.x - source.x) < 0 ? -1 : 1;
        }
        int deltaY = 0;
        if ((dest.y - source.y) != 0) {
            deltaY = (dest.y - source.y) < 0 ? -1 : 1;
        }
        for (int i = 0; i < sizeSteps; i++) {
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

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
