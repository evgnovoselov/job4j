package ru.job4j.profession;

/**
 * Базовый класс Профессий
 *
 * @author Evgeny Novoselov
 */
public class Profession {
    private String name;
    private String profession;

    /**
     * Конструктор объекта профессии.
     *
     * @param name       Имя человека.
     * @param profession Профессия.
     */
    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * Метод возвращает имя.
     *
     * @return Имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод изменяет имя.
     *
     * @param name Имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает профессию.
     *
     * @return Профессия.
     */
    public String getProfession() {
        return profession;
    }
}
