package ru.job4j.exam;

import java.util.*;

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
        Set<String> departments = new HashSet<>(Arrays.asList(departmentsArray));
        addMissed(departments);
        System.out.println(departments);
        Set<String> reverseDepartments = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                int result = 0;
                if (s.length() == t1.length()
                        || s.length() < t1.length() && !s.equals(t1.substring(0, s.length()))) {
                    result = t1.compareTo(s);
                }
                if (s.length() < t1.length() && s.equals(t1.substring(0, s.length()))
                        || s.length() > t1.length() && t1.equals(s.substring(0, t1.length()))) {
                    result = s.compareTo(t1);
                }
                return result;
            }
        });
        reverseDepartments.addAll(departments);
        System.out.println(reverseDepartments);
        String[] result = new String[reverseDepartments.size()];
        return reverseDepartments.toArray(result);
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