package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Класс рисования пирамиды в псевдографике
 *
 * @author Evgeny Novoselov
 */
public class Paint {
    /**
     * Рисуем пирамиду в псевдографике с заданой высотой
     *
     * @param height Высота пирамиды
     * @return Возвращаем пирамиду в псевдографике
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Рисуем правосторонний треугольник
     *
     * @param height Высота
     * @return Возвращаем правосторонний треугльник
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Рисуем левосторонний треугольник
     *
     * @param height Высота
     * @return Возвращаем левосторонний треугльник
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Универсальный метод для рисования пирамиды
     *
     * @param height  Высота пирамиды
     * @param weight  Ширина пирамиды
     * @param predict Предикат двух аргументов, для условия
     * @return Возвращаем строковое представление пирамиды
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder pyramid = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    pyramid.append("^");
                } else {
                    pyramid.append(" ");
                }
            }
            pyramid.append(System.lineSeparator());
        }
        return pyramid.toString();
    }
}
