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
    public void whenConvertUserListToMapThenMapUsers() {
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
}
