package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты банка клиентов.
 *
 * @author Evgeny Novoselov
 */
public class BankTest {
    /**
     * Тестируем добавления пользователя со счетом.
     */
    @Test
    public void whenAddUserWithAccountsThenBankHasIt() {
        Bank bank = new Bank();
        bank.addUser(new User("Evgeny", "11"));
        bank.addAccountToUser("11", new Account("1111"));
        bank.addAccountToUser("11", new Account("2222"));
        List<Account> expected = new ArrayList<>(Arrays.asList(new Account("1111"), new Account("2222")));
        assertThat(bank.getUserAccounts("11"), is(expected));
    }

    /**
     * Тестируем удаление пользователя со счетами.
     */
    @Test
    public void whenDeleteUserWithAccountsThenBankDoNotHasIt() {
        Bank bank = new Bank();
        bank.addUser(new User("Evgeny", "11"));
        bank.addAccountToUser("11", new Account("1111"));
        bank.addAccountToUser("11", new Account("2222"));
        bank.deleteUser(new User("Evgeny", "11"));
        assertThat(bank.getUserAccounts("11"), is(nullValue()));
    }

    /**
     * Тестируем удаление счета у пользователя.
     */
    @Test
    public void whenDeleteAccountFromUserThenBankDoNotHasIt() {
        Bank bank = new Bank();
        bank.addUser(new User("Evgeny", "11"));
        bank.addAccountToUser("11", new Account("1111"));
        bank.addAccountToUser("11", new Account("2222"));
        bank.deleteAccountFromUser("11", new Account("2222"));
        List<Account> expected = new ArrayList<>(Collections.singletonList(new Account("1111")));
        assertThat(bank.getUserAccounts("11"), is(expected));
    }

    /**
     * Тестируем метод для перечисления денег с одного счёта на другой счёт пользователя.
     */
    @Test
    public void whenUserTransferMoneyFromFirstAccountToSecondThenSecondAccountHasMoney() {
    }

    /**
     * Тестируем метод для перечисления денег с одного счёта на счёт другого пользователя.
     */
    @Test
    public void whenFromUserAccountTransferMoneyToAccountOtherUserThenAccountOtherUserHasMoney() {
    }
}
