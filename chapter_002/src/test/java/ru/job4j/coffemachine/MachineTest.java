package ru.job4j.coffemachine;

import org.junit.Test;
import ru.job4j.coffeemachine.Machine;
import ru.job4j.coffeemachine.NeedMoreMoneyException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование метода выдачи сдачи для автомата.
 *
 * @author Evgeny Novoselov
 */
public class MachineTest {
    /**
     * Пример. Мы внесли 50 рублей выбрали кофе за 35. Сдачу автомат должен дать 15 рублей
     */
    @Test
    public void whenBuyCoffeeFor35NeedChanges50ThenGetChange() throws NeedMoreMoneyException {
        assertThat(
                Machine.changes(50, 35),
                is(new int[]{10, 5})
        );
    }

    /**
     * Пример. Мы внесли 50 рублей выбрали кофе за 27. Сдачу автомат должен дать 23 рублей
     */
    @Test
    public void whenBuyCoffeeFor27NeedChanges50ThenGetChange() throws NeedMoreMoneyException {
        assertThat(
                Machine.changes(50, 27),
                is(new int[]{10, 10, 2, 1})
        );
    }

    /**
     * Проверка когда денег не хватает.
     */
    @Test(expected = NeedMoreMoneyException.class)
    public void whenBuyCoffeeFor70NeedChanges50ThenGetException() throws NeedMoreMoneyException {
        Machine.changes(50, 70);
    }
}
