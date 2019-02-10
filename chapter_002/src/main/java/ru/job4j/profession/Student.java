package ru.job4j.profession;

/**
 * Класс студента.
 *
 * @author Evgeny Novoselov
 */
public class Student {
    private String name;

    /**
     * Конструктор объекта студента.
     *
     * @param name Имя студента.
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * Получение имени студента.
     *
     * @return Имя студента.
     */
    public String getName() {
        return name;
    }

    /**
     * Изменение имени студента.
     *
     * @param name Имя студента.
     */
    public void setName(String name) {
        this.name = name;
    }
}
