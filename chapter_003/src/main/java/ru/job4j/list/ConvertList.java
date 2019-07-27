package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс конвертации в List.
 *
 * @author Evgeny Novoselov
 */
public class ConvertList {
    /**
     * Конвертируем коллекцию с массивами в одну общую коллекцию.
     *
     * @param list Коллекция с массивами
     * @return Общая коллекция с элементами из массив коллекции.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] nums : list) {
            for (int num : nums) {
                result.add(num);
            }
        }
        return result;
    }
}
