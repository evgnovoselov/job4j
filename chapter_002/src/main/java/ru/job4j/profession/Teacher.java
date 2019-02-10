package ru.job4j.profession;

/**
 * Класс професии учителя.
 *
 * @author Evgeny Novoselov
 */
public class Teacher extends Profession {
    /**
     * Конструктор объекта профессии учителя.
     *
     * @param name Имя учителя.
     */
    public Teacher(String name) {
        super(name, "Учитель");
    }

    /**
     * Обучение студента.
     *
     * @param student Студент.
     */
    public void teache(Student student) {
    }
}
