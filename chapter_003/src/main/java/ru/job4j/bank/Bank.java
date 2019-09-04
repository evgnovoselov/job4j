package ru.job4j.bank;

import java.util.*;

/**
 * Банк клиентов с ихними счетами.
 *
 * @author Evgeny Novoselov
 */
public class Bank {
    private Map<User, List<Account>> clients = new HashMap<>();

    /**
     * Добавление пользователя.
     *
     * @param user Пользователь.
     */
    public void addUser(User user) {
        clients.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаление пользователя.
     *
     * @param user Пользователь.
     */
    public void deleteUser(User user) {
        clients.remove(user);
    }

    /**
     * Добавить счёт пользователю.
     *
     * @param passport Пасспорт пользователя.
     * @param account  Счет пользователя.
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        int indexAccount = accounts.indexOf(account);
        if (indexAccount < 0) {
            accounts.add(account);
        }
    }

    /**
     * Удалить один счёт пользователя.
     *
     * @param passport Пасспорт пользователя.
     * @param account  Счет пользователя.
     */
    public void deleteAccountFromUser(String passport, Account account) {
    }

    /**
     * Получить список счетов пользователя.
     *
     * @param passport Пасспорт пользователя.
     * @return Список счетов пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = null;
        for (Map.Entry<User, List<Account>> client : clients.entrySet()) {
            if (client.getKey().getPassport().equals(passport)) {
                result = client.getValue();
            }
        }
        return result;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт:
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят деньги) метод должен вернуть false.
     *
     * @param srcPassport   Пасспорт пользователя с которого списывают деньги.
     * @param srcRequisite  Реквизиты счёта откуда переводят деньги.
     * @param destPassport  Пасспорт пользователя которому начисляют деньги.
     * @param destRequisite Реквизиты счёта куда переводят деньги.
     * @param amount        Количество денег для перевода на dest счет.
     * @return Успешность перевода денег.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        return false;
    }
}
