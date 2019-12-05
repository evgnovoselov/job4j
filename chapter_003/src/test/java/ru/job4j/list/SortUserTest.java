package ru.job4j.list;

import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирования сортировки пользователей.
 *
 * @author Evgeny Novoselov
 */
public class SortUserTest {
    /**
     * Метод проверяет сортировку пользователей.
     */
    @Test
    public void whenSortUserListToSetThenSortedSet() {
        List<User> users = List.of(
                new User("Evgeny", 34, "Moscow"),
                new User("Petr", 33, "Bryansk"),
                new User("Andrey", 32, "Don't know"),
                new User("Evgeny", 31, "Moscow")
        );
        Set<User> expected = new TreeSet<>(Set.of(
                users.get(3),
                users.get(2),
                users.get(1),
                users.get(0)
        ));
        assertThat(new SortUser().sort(users).toString(), is(expected.toString()));
    }

    /**
     * Проверка осортированных пользователей по длине имени.
     */
    @Test
    public void whenSortUsersNameLengthThenSortedUsers() {
        List<User> users = List.of(
                new User("Сергей", 25, "Москва"),
                new User("Иван", 30, "Москва"),
                new User("Сергей", 20, "Москва"),
                new User("Иван", 25, "Москва")
        );
        List<User> expected = List.of(
                users.get(1),
                users.get(3),
                users.get(0),
                users.get(2)
        );
        assertThat(new SortUser().sortNameLength(users).toString(), is(expected.toString()));
    }

    /**
     * Проверка отсортированных пользователей сначало в лексикографическом порядке, потом по возросту.
     */
    @Test
    public void whenSortUsersByAllFieldsThenSortedUsers() {
        List<User> users = List.of(
                new User("Сергей", 25, "Москва"),
                new User("Иван", 30, "Москва"),
                new User("Сергей", 20, "Москва"),
                new User("Иван", 25, "Москва")
        );
        List<User> expected = List.of(
                users.get(3),
                users.get(1),
                users.get(2),
                users.get(0)
        );
        assertThat(new SortUser().sortByAllFields(users).toString(), is(expected.toString()));
    }
}
