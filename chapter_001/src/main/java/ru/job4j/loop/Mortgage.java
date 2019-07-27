package ru.job4j.loop;

/**
 * Класс для вычисления количество лет необходимых для погашения кредита.
 *
 * @author Evgeny Novoselov
 */
public class Mortgage {
    /**
     * Метод вычисления количество лет необходимых для погашения кредита.
     * Кредитная сумма перерасчитывается каждый год по процентной ставке.
     *
     * @param amount  Сумма выданная по кредиту.
     * @param monthly Ежемесячный платеж
     * @param percent Процентная ставка по кредиту.
     * @return Количество лет необходимых для погашения кредита.
     */
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        double credit = amount;
        while (credit > 0) {
            year++;
            credit = (credit + credit * percent / 100) - monthly * 12;
        }
        return year;
    }
}
