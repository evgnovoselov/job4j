package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        List<User> users = new ArrayList<>();
        users.add(new User("Evgeny", "Moscow"));
        users.add(new User("Petr", "Bryansk"));
        users.add(new User("Andrey", "Don't know"));
        users.add(new User("Evgeny", "Moscow"));
        HashMap<Integer, User> result = new HashMap<>();
        result.put(users.get(0).getId(), users.get(0));
        result.put(users.get(1).getId(), users.get(1));
        result.put(users.get(2).getId(), users.get(2));
        result.put(users.get(3).getId(), users.get(3));
        assertThat(new UserConvert().process(users), is(result));
    }
}
