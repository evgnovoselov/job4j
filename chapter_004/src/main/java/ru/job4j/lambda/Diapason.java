package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Класс для метода подсчета функции в диапазоне.
 *
 * @author Evgeny Novoselov
 */
public class Diapason {
    /**
     * Метод подсчета функции в диапазоне.
     *
     * @param start Начальное значение.
     * @param end   Конечное значение.
     * @param func  Функция подсчета.
     * @return Список решений функции с указаным диапазоном.
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }
}
