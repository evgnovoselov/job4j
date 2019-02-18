package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса рисования фигуры
 *
 * @author Evgeny Novoselov
 */
public class PaintTest {
    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Метод заменяет стандартный вывод на вывод в пямять для тестирования.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Метод возвращает обратно стандартный вывод в консоль.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Тестирование метода рисования квадрата
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++++++").append(System.lineSeparator())
                                .append("+      +").append(System.lineSeparator())
                                .append("+      +").append(System.lineSeparator())
                                .append("++++++++").append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
     * Тестирование метода рисования треугольника
     */
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   +").append(System.lineSeparator())
                                .append("  +++").append(System.lineSeparator())
                                .append(" +++++").append(System.lineSeparator())
                                .append("+++++++").append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
