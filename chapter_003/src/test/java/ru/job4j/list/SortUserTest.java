package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

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
        List<User> users = new ArrayList<>();
        users.add(new User("Evgeny", 34, "Moscow"));
        users.add(new User("Petr", 33, "Bryansk"));
        users.add(new User("Andrey", 32, "Don't know"));
        users.add(new User("Evgeny", 31, "Moscow"));
        LinkedHashSet<User> expected = new LinkedHashSet<>();
        expected.add(users.get(3));
        expected.add(users.get(2));
        expected.add(users.get(1));
        expected.add(users.get(0));
        assertThat(new SortUser().sort(users).toString(), is(expected.toString()));
    }

    /**
     * Проверка осортированных пользователей по длине имени.
     */
    @Test
    public void whenSortUsersNameLengthThenSortedUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Сергей", 25, "Москва"));
        users.add(new User("Иван", 30, "Москва"));
        users.add(new User("Сергей", 20, "Москва"));
        users.add(new User("Иван", 25, "Москва"));
        List<User> expected = new ArrayList<>();
        expected.add(users.get(1));
        expected.add(users.get(3));
        expected.add(users.get(0));
        expected.add(users.get(2));
        assertThat(new SortUser().sortNameLength(users).toString(), is(expected.toString()));
    }

    /**
     * Проверка отсортированных пользователей сначало в лексикографическом порядке, потом по возросту.
     */
    @Test
    public void whenSortUsersByAllFieldsThenSortedUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Сергей", 25, "Москва"));
        users.add(new User("Иван", 30, "Москва"));
        users.add(new User("Сергей", 20, "Москва"));
        users.add(new User("Иван", 25, "Москва"));
        List<User> expected = new ArrayList<>();
        expected.add(users.get(3));
        expected.add(users.get(1));
        expected.add(users.get(2));
        expected.add(users.get(0));
        assertThat(new SortUser().sortByAllFields(users).toString(), is(expected.toString()));
    }

}
