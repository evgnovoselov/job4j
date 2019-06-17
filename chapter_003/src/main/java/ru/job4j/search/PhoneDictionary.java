package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Справочник людей.
 *
 * @author Evgeny Novoselov
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    /**
     * Метод добавляет человека в библиотеку.
     *
     * @param person Карточка человека.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        String keyLowerCase = key.toLowerCase();
        for (Person person : persons) {
            if (person.getName().toLowerCase().contains(keyLowerCase)
                    || person.getSurname().toLowerCase().contains(keyLowerCase)
                    || person.getPhone().toLowerCase().contains(keyLowerCase)
                    || person.getAddress().toLowerCase().contains(keyLowerCase)
            ) {
                result.add(person);
            }
        }
        return result;
    }
}
