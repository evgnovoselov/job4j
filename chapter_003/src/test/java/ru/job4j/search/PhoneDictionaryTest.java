package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса справочника людей.
 *
 * @author Evgeny Novoselov
 */
public class PhoneDictionaryTest {
    /**
     * Тестируем поиск записи по имени.
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Evgeny", "Novoselov", "317297", "Moscow"));
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Тестируем поиск без привязки к регистру.
     */
    @Test
    public void whenFindBySurnameLowerCase() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Evgeny", "Novoselov", "317297", "Moscow"));
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("Sen");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}
