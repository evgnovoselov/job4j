package ru.job4j.profession;

/**
 * Класс врача.
 *
 * @author Evgeny Novoselov
 */
public class Doctor extends Profession {
    /**
     * Конструктор объеката врача.
     *
     * @param name Имя врача.
     */
    public Doctor(String name) {
        super(name, "Доктор");
    }

    /**
     * Класс лечения доктором.
     *
     * @param patient Прибывший пациент.
     * @return Возвращает диагноз пациента.
     */
    public Diagnose heal(Patient patient) {
        return new Diagnose(this, patient, "ОРВИ");
    }
}
