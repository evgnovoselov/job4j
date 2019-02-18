package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирования рисования треугольника
 *
 * @author Evgeny Novoselov
 */
public class TriangleTest {
    /**
     * Тестирование метода рисования треугольника
     */
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   +").append(System.lineSeparator())
                                .append("  +++").append(System.lineSeparator())
                                .append(" +++++").append(System.lineSeparator())
                                .append("+++++++").append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
