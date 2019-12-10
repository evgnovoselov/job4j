package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate) {
        boolean result = false;
        int countDiagonal = 0;
        int countReverseDiagonal = 0;
        for (int row = 0; row < this.table.length; row++) {
            int countCol = 0;
            for (int col = 0; col < this.table.length; col++) {
                int countRow = 0;
                if (predicate.test(this.table[row][col])) {
                    countCol++;
                }
                if (row == 0) {
                    for (row = 0; row < this.table.length; row++) {
                        if (predicate.test(this.table[row][col])) {
                            countRow++;
                        }
                    }
                    row = 0;
                    if (countRow == this.table.length) {
                        result = true;
                        break;
                    }
                }
            }
            if (predicate.test(this.table[row][row])) {
                countDiagonal++;
            }
            if (predicate.test(this.table[this.table.length - 1 - row][row])) {
                countReverseDiagonal++;
            }
            if (result
                    || countCol >= this.table.length
                    || countDiagonal >= this.table.length
                    || countReverseDiagonal >= this.table.length
            ) {
                result = true;
                break;
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
        return true;
    }
}
