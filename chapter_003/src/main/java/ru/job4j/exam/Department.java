package ru.job4j.exam;

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
        Set<Node> departmentsNode = getDepartmentsNode(departmentsArray);
        System.out.println(departmentsNode);
        return new String[]{"1", "2"};
    }

    /**
     * Возврашаем множество отделов с подотделами из массива строк содержащий структуру отделов.
     *
     * @param departmentsArray Массив строк, содержащий информацио об отделах.
     * @return Множество отделов с подотделами.
     */
    private static Set<Node> getDepartmentsNode(String[] departmentsArray) {
        Set<Node> result = new TreeSet<>();
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

    private static class Node implements Comparable<Node> {
        String department = "";
        Set<Node> subDepartments = new TreeSet<>();

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