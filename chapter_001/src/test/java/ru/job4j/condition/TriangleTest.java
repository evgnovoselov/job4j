package ru.job4j.condition;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Тест класса описывающий треугольник
 */
public class TriangleTest {
    /**
     * Тест метода получения площади по 3-ем точкам
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
}
