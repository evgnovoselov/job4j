package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует конвертацию пользователей.
 *
 * @author Evgeny Novoselov
 */
public class UserConvertTest {
    /**
     * Метод тестирует конвертацию пользователей в отображение пользователей по Id.
     */
    @Test
    public void whenConvertUserListToMapThenMapUsers() {
        List<User> users = List.of(
                new User("Evgeny", 34, "Moscow"),
                new User("Petr", 33, "Bryansk"),
                new User("Andrey", 32, "Don't know"),
                new User("Evgeny", 31, "Moscow")
        );
        Map<Integer, User> result = Map.of(
                users.get(0).getId(), users.get(0),
                users.get(1).getId(), users.get(1),
                users.get(2).getId(), users.get(2),
                users.get(3).getId(), users.get(3)
        );
        assertThat(new UserConvert().process(users), is(result));
    }
}
