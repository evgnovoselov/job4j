package ru.job4j.converter;

/**
 * Корвертер валюты.
 */
public class Converter {
    /**
     * Конвертируем рубли в евро.
     * По курсу 1 Евро = 70 рублей
     *
     * @param ruble рубли.
     * @return Евро.
     */
    public int rubleToEuro(int ruble) {
        return ruble / 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * По курсу 1 Доллар = 60 рублей
     *
     * @param ruble рубли.
     * @return Доллары
     */
    public int rubleToDollar(int ruble) {
        return ruble / 60;
    }

    /**
     * Конвертируем евро в рубли
     * По курсу 1 Евро = 70 рублей
     *
     * @param euro Евро
     * @return Рубли
     */
    public int euroToRuble(int euro) {
        return euro * 70;
    }

    /**
     * Конвертируем доллар в рубли
     * По курсу 1 Доллар = 60 рублей
     *
     * @param dollar Доллар
     * @return Рубли
     */
    public int dollarToRuble(int dollar) {
        return dollar * 60;
    }
}
