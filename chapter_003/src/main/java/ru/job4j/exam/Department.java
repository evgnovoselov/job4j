package ru.job4j.exam;

import java.util.*;

/**
 * Функции для сортировки справочника подразделений.
 *
 * @author Evgeny Novoselov
 */
public class Department {
    /**
     * Реверсивная сортировка.
     */
    private static boolean methodsReverseSort;

    /**
     * Метод сортировки департаментов.
     * Ставит метод сортировки.
     *
     * @param departmentsArray Массив департаментов.
     * @return Отсортированный по возростанию массив департаментов.
     */
    public static String[] sort(String[] departmentsArray) {
        methodsReverseSort = false;
        return doSort(departmentsArray);
    }

    /**
     * Метод обратной сортировки департаментов.
     * Ставит метод сортировки.
     *
     * @param departmentsArray Массив департаментов.
     * @return Отсортированный по убыванию массив департаментов.
     */
    public static String[] reverseSort(String[] departmentsArray) {
        methodsReverseSort = true;
        return doSort(departmentsArray);
    }

    /**
     * Метод осуществляет сортировку
     *
     * @param departmentsArray Массив департаментов.
     * @return Отсортированный массив департаментов.
     */
    private static String[] doSort(String[] departmentsArray) {
        Set<Node> departmentsNode = getDepartmentsNode(departmentsArray);
        List<String> departmentsList = getDepartmentsList(departmentsNode);
        String[] departmentsSortArray = new String[departmentsList.size()];
        return departmentsList.toArray(departmentsSortArray);
    }

    /**
     * Возвращаем список департаментов.
     *
     * @param departmentsNode Множество департаментов с отделами.
     * @return Возвращаем строки с отделами.
     */
    private static List<String> getDepartmentsList(Set<Node> departmentsNode) {
        return new ArrayList<>(getDepartmentsListWithPrefix(departmentsNode, ""));
    }

    /**
     * Возвращаем список департаментов с использованием префикса.
     *
     * @param departmentsNode Множество департаментов с отделами.
     * @param prefix          Префикс из родительских отделов.
     * @return Возвращаем список отделов с полной структурой.
     */
    private static List<String> getDepartmentsListWithPrefix(Set<Node> departmentsNode, String prefix) {
        List<String> result = new ArrayList<>();
        for (Node node : departmentsNode) {
            StringBuilder prefixBuilder = new StringBuilder(prefix);
            result.add(prefixBuilder.toString() + node.department);
            if (!node.subDepartments.isEmpty()) {
                prefixBuilder.append(node.department).append("\\");
                result.addAll(getDepartmentsListWithPrefix(node.subDepartments, prefixBuilder.toString()));
            }
        }
        return result;
    }

    /**
     * Возврашаем множество отделов с подотделами из массива строк содержащий структуру отделов.
     *
     * @param departmentsArray Массив строк, содержащий информацио об отделах.
     * @return Множество отделов с подотделами.
     */
    private static Set<Node> getDepartmentsNode(String[] departmentsArray) {
        Set<Node> result = new TreeSet<>(getSortComporator());
        for (String departmentsStr : departmentsArray) {
            Node node = getDepartmentsNodeFromString(departmentsStr);
            if (!result.add(node)) {
                for (Node nodeResult : result) {
                    if (nodeResult.department.equals(node.department)) {
                        mergeNodes(node, nodeResult);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Объединяем узлы.
     *
     * @param from Откуда сливаем.
     * @param to   Куда сливаем.
     */
    private static void mergeNodes(Node from, Node to) {
        for (Node nodeTo : to.subDepartments) {
            for (Node nodeFrom : from.subDepartments) {
                if (nodeTo.department.equals(nodeFrom.department)) {
                    mergeNodes(nodeFrom, nodeTo);
                }
            }
        }
        to.subDepartments.addAll(from.subDepartments);
    }

    /**
     * Метод парсит строку на главный отдел со строкой содержащую его структуру.
     *
     * @param departmentsStr Строка содержащая информацию об отделе.
     * @return Возвращаем узел отдела с информацией об подотделах.
     */
    private static Node getDepartmentsNodeFromString(String departmentsStr) {
        Node result = new Node();
        String[] sections = departmentsStr.split("\\W", 2);
        result.department = sections[0];
        if (sections.length > 1) {
            result.subDepartments.add(getDepartmentsNodeFromString(sections[1]));
        }
        return result;
    }

    /**
     * Возвращаем необходимый компаратор, для сортировки элементов.
     *
     * @param <T> Класс реализующий Comparable
     * @return Возвращаем компоратор.
     */
    private static <T extends Comparable> Comparator<T> getSortComporator() {
        Comparator<T> result = null;
        if (methodsReverseSort) {
            result = Collections.reverseOrder();
        }
        return result;
    }

    private static class Node implements Comparable<Node> {
        String department = "";
        Set<Node> subDepartments = new TreeSet<>(getSortComporator());

        @Override
        public String toString() {
            return department + "->" + subDepartments;
        }

        @Override
        public int compareTo(Node node) {
            return this.department.compareTo(node.department);
        }
    }
}