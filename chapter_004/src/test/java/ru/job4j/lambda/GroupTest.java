package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование метода группировки студентов по курсам.
 *
 * @author Evgeny Novoselov
 */
public class GroupTest {
    /**
     * Метод проверяет группировку студентов по курсам.
     */
    @Test
    public void whenStudentsGroupToUnitThenMapUnitWithStudents() {
        var students = List.of(
                new Student("Ivan", Set.of("u1", "u2")),
                new Student("Alex", Set.of("u1", "u3")),
                new Student("John", Set.of("u2", "u3"))
        );
        var expected = Map.of(
                "u1", Set.of("Ivan", "Alex"),
                "u2", Set.of("Ivan", "John"),
                "u3", Set.of("Alex", "John")
        );
        assertThat(Group.sections(students), is(expected));
    }
}
