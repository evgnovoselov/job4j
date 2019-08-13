package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс сортировки пользователей.
 *
 * @author Evgeny Novoselov
 */
public class SortUser {
    /**
     * Сортирует список пользователей
     *
     * @param users Список пользователей.
     * @return Множество пользователей.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * Todo add comments
     *
     * @return
     */
    public List<User> sortNameLength(List<User> users) {
        return new ArrayList<>();
    }

    /**
     * Todo comments
     *
     * @return
     */
    public List<User> sortByAllFields(List<User> users) {
        return new ArrayList<>();
    }
}
