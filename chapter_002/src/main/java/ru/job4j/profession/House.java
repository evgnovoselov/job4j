package ru.job4j.profession;

/**
 * Класс дома.
 *
 * @author Evgeny Novoselov
 */
public class House {
    private String status = "Котлован";
    private Engineer engineer;

    /**
     * Получение статуса дома.
     *
     * @return Статус.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Сохранение статуса дома.
     *
     * @param status Статус.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Получение главного инженера.
     *
     * @return Главный инженер.
     */
    public Engineer getEngineer() {
        return engineer;
    }

    /**
     * Изменение главного инженера.
     *
     * @param engineer Главный инженер.
     */
    public void setEngineer(Engineer engineer) {
        this.engineer = engineer;
    }
}
