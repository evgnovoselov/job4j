package ru.job4j.tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate) {
        boolean result = false;
        int countDiagonal = 0;
        int countReverseDiagonal = 0;
        int[] countCols = new int[this.table.length];
        int[] countRows = new int[this.table.length];
        List<Figure3T> figures = Arrays.stream(this.table).flatMap(Stream::of).collect(Collectors.toList());
        for (int row = 0; row < this.table.length; row++) {
            if (result) {
                break;
            }
            if (predicate.test(figures.get(row + row * this.table.length))) {
                countDiagonal++;
                if (countDiagonal >= this.table.length) {
                    result = true;
                    break;
                }
            }
            if (predicate.test(figures.get((this.table.length - 1) * row + this.table.length - 1))) {
                countReverseDiagonal++;
                if (countReverseDiagonal >= this.table.length) {
                    result = true;
                    break;
                }
            }
            for (int col = 0; col < this.table.length; col++) {
                if (predicate.test(figures.get(row * this.table.length + col))) {
                    countRows[row]++;
                    if (countRows[row] >= this.table.length) {
                        result = true;
                        break;
                    }
                }
                if (predicate.test(figures.get(row + this.table.length * col))) {
                    countCols[row]++;
                    if (countCols[row] >= this.table.length) {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(this.table).flatMap(Stream::of).anyMatch(e -> !e.hasMarkO() && !e.hasMarkX());
    }
}
