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
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(
                predict::test
        ).collect(Collectors.toList());
    }
}
