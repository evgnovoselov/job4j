package ru.job4j.loop;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для теста класса рисования пирамиды в псевдографике
 *
 * @author Evgeny Novoselov
 */
public class PaintTest {
    /**
     * Тестируем пирамиду высотой 2
     */
    @Test
    public void whenPaintPyramidHeight2() {
        Paint paint = new Paint();
        String rst = paint.pyramid(2);
        assertThat(rst, is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add(" ^ ")
                        .add("^^^")
                        .toString()
                )
        );
    }

    /**
     * Тестируем пирамиду высотой 3
     */
    @Test
    public void whenPaintPyramidHeight3() {
        Paint paint = new Paint();
        String rst = paint.pyramid(3);
        assertThat(rst, is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("  ^  ")
                        .add(" ^^^ ")
                        .add("^^^^^")
                        .toString()
                )
        );
    }

    /**
     * Тестирование правостороннего треугольника
     */
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rst = paint.rightTrl(4);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("^   ")
                                .add("^^  ")
                                .add("^^^ ")
                                .add("^^^^")
                                .toString()
                )
        );
    }
    /**
     * Тестирование левостороннего треугольника
     */
    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(4);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^")
                                .add("  ^^")
                                .add(" ^^^")
                                .add("^^^^")
                                .toString()
                )
        );
    }
}
