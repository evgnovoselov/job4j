package ru.job4j.stream.matrix;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс преобразования.
 *
 * @author Evgeny Novoselov
 */
public class Convert {
    /**
     * Метод преобразования матрицы чисел в список чисел.
     *
     * @param integers матрица чисел.
     * @return список чисел.
     */
    public static List<Integer> toList(Integer[][] integers) {
        return Stream.of(integers).flatMap(Stream::of).collect(Collectors.toList());
    }
}
