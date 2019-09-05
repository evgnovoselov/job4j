package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void whenAddUserWithAccountsThenHaveIt() {
        Bank bank = new Bank();
        bank.addUser(new User("Evgeny", "11"));
        bank.addAccountToUser("11", new Account("1111"));
        bank.addAccountToUser("11", new Account("2222"));
        List<Account> expected = new ArrayList<>(Arrays.asList(new Account("1111"), new Account("2222")));
        assertThat(bank.getUserAccounts("11"), is(expected));
    }
}
