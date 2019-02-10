package ru.job4j.profession;

/**
 * Класс пациента.
 *
 * @author Evgeny Novoselov
 */
public class Patient {
    private String name;

    /**
     * Конструктор объекта пациент.
     *
     * @param name Имя пациента.
     */
    public Patient(String name) {
        this.name = name;
    }

    /**
     * Получение имени пациента.
     *
     * @return Имя пациента.
     */
    public String getName() {
        return name;
    }

    /**
     * Изменение имени пациента.
     *
     * @param name Имя пациента.
     */
    public void setName(String name) {
        this.name = name;
    }
}
