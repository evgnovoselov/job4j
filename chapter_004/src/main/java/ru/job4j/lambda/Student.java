package ru.job4j.lambda;

import java.util.Set;

/**
 * Студенты со списком секций, которые он посещает.
 *
 * @author Evgeny Novoselov
 */
public class Student {
    private String name;
    private Set<String> units;

    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public Set<String> getUnits() {
        return units;
    }
}
