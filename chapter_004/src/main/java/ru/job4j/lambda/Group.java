package ru.job4j.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Класс для группировки студентов.
 *
 * @author Evgeny Novoselov
 */
public class Group {
    /**
     * Метод группирует студентов по группам.
     *
     * @param students список студентов.
     * @return отображение групп со студеннтами.
     */
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream().flatMap(
                student -> student.getUnits().stream().map(el -> new Holder(el, student.getName()))
        ).collect(
                Collectors.groupingBy(
                        t -> t.key,
                        Collector.of(
                                HashSet::new,
                                (set, el) -> set.add(el.value),
                                (set1, set2) -> {
                                    set1.addAll(set2);
                                    return set1;
                                }
                        )
                )
        );
    }

    /**
     * Дополнительный класс для содержания секции и студента.
     */
    private static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
