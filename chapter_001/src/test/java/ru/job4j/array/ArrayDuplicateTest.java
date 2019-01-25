package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирует класс удаления дублирующих значений из массива
 *
 * @author Evgeny Novoselov
 */
public class ArrayDuplicateTest {
    /**
     * Теструет метод удаления из массива дублирующих значений
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир", "Мир", "Мир"};
        String[] expect = {"Привет", "Мир", "Супер"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(array);
        assertThat(result, is(expect));
    }
}
