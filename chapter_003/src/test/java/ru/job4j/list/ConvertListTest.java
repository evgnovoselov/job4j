package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем класс конвертации коллекции.
 *
 * @author Evgeny Novoselov
 */
public class ConvertListTest {
    /**
     * Тестируем конвертацию коллекции содержащей массивы int[] в общую коллекцию из содержащих элементов.
     */
    @Test
    public void whenListArraysConvertThenList() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        assertThat(new ConvertList().convert(list), is(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }
}
