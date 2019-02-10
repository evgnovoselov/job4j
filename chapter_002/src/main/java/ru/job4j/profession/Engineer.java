package ru.job4j.profession;

/**
 * Класс профессии инженер.
 *
 * @author Evgeny Novoselov
 */
public class Engineer extends Profession {
    /**
     * Конструктор объекта профессии инженер.
     *
     * @param name Имя инженера.
     */
    public Engineer(String name) {
        super(name, "Инженер");
    }

    /**
     * Стройка дома инженером.
     *
     * @param house Дом.
     */
    public void build(House house) {
    }
}
