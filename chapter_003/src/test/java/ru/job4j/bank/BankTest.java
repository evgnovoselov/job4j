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
        List<Account> expected = Arrays.asList(new Account("1111"), new Account("2222"));
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
        assertThat(bank.getUserAccounts("11"), is(new ArrayList<>()));
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
        List<Account> expected = Collections.singletonList(new Account("1111"));
        assertThat(bank.getUserAccounts("11"), is(expected));
    }

    /**
     * Тестируем метод для перечисления денег с одного счёта на другой счёт пользователя.
     */
    @Test
    public void whenUserTransferMoneyFromFirstAccountToSecondThenSecondAccountHasMoney() {
        Bank bank = new Bank();
        bank.addUser(new User("Evgeny", "11"));
        bank.addAccountToUser("11", new Account("1111"));
        bank.getUserAccounts("11").get(0).setValue(1000);
        bank.addAccountToUser("11", new Account("2222"));
        assertThat(bank.transferMoney(
                "11", "1111",
                "11", "2222",
                450), is(true)
        );
        assertThat(new Double[]{
                bank.getUserAccounts("11").get(0).getValue(),
                bank.getUserAccounts("11").get(1).getValue(),
        }, is(new Double[]{
                550.0,
                450.0,
        }));
    }

    /**
     * Тестируем метод для перечисления денег с одного счёта на котором не хватает денег, на другой счёт пользователя.
     */
    @Test
    public void whenUserTransferMoneyFromFirstAccountToSecondButNotHaveMoneyThenSecondAccountNotHasMoney() {
        Bank bank = new Bank();
        bank.addUser(new User("Evgeny", "11"));
        bank.addAccountToUser("11", new Account("1111"));
        bank.getUserAccounts("11").get(0).setValue(300);
        bank.addAccountToUser("11", new Account("2222"));
        assertThat(bank.transferMoney(
                "11", "1111",
                "11", "2222",
                450), is(false)
        );
        assertThat(new Double[]{
                bank.getUserAccounts("11").get(0).getValue(),
                bank.getUserAccounts("11").get(1).getValue(),
        }, is(new Double[]{
                300.0,
                0.0,
        }));
    }

    /**
     * Тестируем метод для перечисления денег с одного счёта на счёт другого пользователя.
     */
    @Test
    public void whenFromUserAccountTransferMoneyToAccountOtherUserThenAccountOtherUserHasMoney() {
        Bank bank = new Bank();
        bank.addUser(new User("Evgeny", "11"));
        bank.addAccountToUser("11", new Account("1111"));
        bank.getUserAccounts("11").get(0).setValue(1000);
        bank.addUser(new User("Petr", "22"));
        bank.addAccountToUser("22", new Account("2222"));
        assertThat(bank.transferMoney(
                "11", "1111",
                "22", "2222",
                450), is(true)
        );
        assertThat(new Double[]{
                bank.getUserAccounts("11").get(0).getValue(),
                bank.getUserAccounts("22").get(0).getValue(),
        }, is(new Double[]{
                550.0,
                450.0,
        }));
    }

    /**
     * Тестируем метод для перечисления денег с одного счёта на котором не хватает денег, на счёт другого пользователя.
     */
    @Test
    public void whenFromUserAccountTransferMoneyButHisNotHaveMoneyToAccountOtherUserThenAccountOtherUserDoNotHasMoney() {
        Bank bank = new Bank();
        bank.addUser(new User("Evgeny", "11"));
        bank.addAccountToUser("11", new Account("1111"));
        bank.getUserAccounts("11").get(0).setValue(300);
        bank.addUser(new User("Petr", "22"));
        bank.addAccountToUser("22", new Account("2222"));
        assertThat(bank.transferMoney(
                "11", "1111",
                "22", "2222",
                450), is(false)
        );
        assertThat(new Double[]{
                bank.getUserAccounts("11").get(0).getValue(),
                bank.getUserAccounts("22").get(0).getValue(),
        }, is(new Double[]{
                300.0,
                0.0,
        }));
    }
}
