package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирования сортировки департаментов.
 *
 * @author Evgeny Novoselov
 */
public class DepartmentTest {
    /**
     * Сортируем департаменты в порядке возростания.
     */
    @Test
    public void whenDepartmentsSortThenGetDepartmentsSort() {
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
        String[] departmentsSortAsc = Department.sort(departments);
        assertThat(departmentsSortAsc, is(expected));
    }

    /**
     * Сортируем департаменты в порядке убывания.
     */
    @Test
    public void whenDepartmentsReversSortThenDepartmentsReversSort() {
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