package ru.job4j.bank;

import java.util.Objects;

/**
 * Счет в банке.
 *
 * @author Evgeny Novoselov
 */
public class Account {
    private double value = 0;
    private String requisites;

    public Account(String requisites) {
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }

    /**
     * Переводит деньги с счета на счет.
     *
     * @param destAcc Куда нужно перевести деньги.
     * @param amount  Сумма списания.
     * @return Результат операции.
     */
    public boolean transferMoney(Account destAcc, double amount) {
        boolean result = false;
        if (amount > 0 && value >= amount) {
            value -= amount;
            destAcc.value += amount;
            result = true;
        }
        return result;
    }
}
