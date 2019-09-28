package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование организации содержащую департаменты.
 *
 * @author Evgeny Novoselov
 */
public class OrganizationTest {
    /**
     * Вносим департаменты в организацию и получаем в порядке возростания.
     */
    @Test
    public void whenAddDepartmentsThenGetDepartmentsAscSort() {
        String[] departments = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        String[] expected = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        Organization organization = new Organization(departments);
        assertThat(departments, is(expected));
    }

    /**
     * Вносим департаменты в организацию и запрашиваем в порядке убывания.
     */
    @Test
    public void whenAddDepartmentsAndGetDescSortThenGetDepartmentsDescSort() {
        String[] departments = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        String[] expected = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1",
        };
        assertThat(departments, is(expected));
    }
}