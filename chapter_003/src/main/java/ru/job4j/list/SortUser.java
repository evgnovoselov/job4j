package ru.job4j.list;

import java.util.*;

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
     * Сортируем пользователей по длине имени.
     *
     * @return Отсортированных пользователей.
     */
    public List<User> sortNameLength(List<User> users) {
        List<User> result = new ArrayList<>(users);
        Collections.sort(result, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return Integer.compare(user.getName().length(), t1.getName().length());
            }
        });
        return result;
    }

    /**
     * Сортируем пользователей сначало в лексикографическом порядке, потом по возросту.
     *
     * @return Отсортированных пользователей.
     */
    public List<User> sortByAllFields(List<User> users) {
        List<User> result = new ArrayList<>(users);
        Collections.sort(result, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getName().compareToIgnoreCase(t1.getName());
            }
        }.thenComparing(new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return Integer.compare(user.getAge(), t1.getAge());
            }
        }));
        return result;
    }
}
