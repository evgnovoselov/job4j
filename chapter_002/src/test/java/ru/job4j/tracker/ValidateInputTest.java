package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса проверки ввода.
 *
 * @author Evgeny Novoselov
 */
public class ValidateInputTest {
    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream out = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();

    /**
     * Метод заменяет стандартный вывод на вывод в пямять для тестирования.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.mem));
    }

    /**
     * Метод возвращает обратно стандартный вывод в консоль.
     */
    @After
    public void backOutput() {
        System.setOut(this.out);
    }

    /**
     * Метод тестирования неверного ввода.
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        new StringBuilder()
                                .append("--------------------------------").append(System.lineSeparator())
                                .append("Неверный формат ввода.").append(System.lineSeparator())
                                .append("Попробуйте еще раз.").append(System.lineSeparator())
                                .append("--------------------------------").append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
