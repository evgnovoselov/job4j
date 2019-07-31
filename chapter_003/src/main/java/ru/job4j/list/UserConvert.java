package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * Класс конвертирует пользователей.
 *
 * @author Evgeny Novoselov
 */
public class UserConvert {
    /**
     * Метод конвертации коллекции User в отображение по Id.
     *
     * @param list Коллекция пользователей
     * @return Возвращаем отображение пользователей по Id.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
