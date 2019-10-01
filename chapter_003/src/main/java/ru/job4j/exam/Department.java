package ru.job4j.exam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Функции для сортировки справочника подразделений.
 *
 * @author Evgeny Novoselov
 */
public class Department {
    /**
     * Метод сортировки департаментов.
     *
     * @param departmentsArray Массив департаментов.
     * @return Отсортированный по возростанию массив департаментов.
     */
    public static String[] sort(String[] departmentsArray) {
        Set<String> departments = new TreeSet<>(Arrays.asList(departmentsArray));
        addMissed(departments);
        String[] result = new String[departments.size()];
        return departments.toArray(result);
    }

    /**
     * Метод обратной сортировки департаментов.
     *
     * @param departmentsArray Массив департаментов.
     * @return Отсортированный по убыванию массив департаментов.
     */
    public static String[] reverseSort(String[] departmentsArray) {
        Set<String> departments = new TreeSet<>(Arrays.asList(departmentsArray));
        addMissed(departments);
        String[] result = new String[departments.size()];
        return departments.toArray(result);
    }

    /**
     * Добавляем недостающие департаменты.
     *
     * @param departments Множество департаментов.
     */
    private static void addMissed(Set<String> departments) {
        Set<String> missed = new HashSet<>();
        for (String department : departments) {
            String[] sections = department.split("\\W");
            StringBuilder departmentAdd = new StringBuilder();
            for (int i = 0; i < sections.length; i++) {
                departmentAdd.append(sections[i]);
                if (!departments.contains(departmentAdd.toString())) {
                    missed.add(departmentAdd.toString());
                }
                if (i + 1 < sections.length) {
                    departmentAdd.append("\\");
                }
            }
        }
        departments.addAll(missed);
    }
}