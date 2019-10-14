package ru.job4j.stream.school;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс школы для получения списка учеников.
 *
 * @author Evgeny Novoselov
 */
public class School {
    /**
     * Фильтруем список учеников по указанному условию predicate.
     *
     * @param students список учеников.
     * @param predict  условие.
     * @return Возвращаем список учеников.
     */
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(
                predict
        ).collect(Collectors.toList());
    }
}