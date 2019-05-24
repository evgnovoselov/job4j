package ru.job4j.coffeemachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация метода выдачи сдачи для автомата.
 *
 * @author Evgeny Novoselov
 */
public class Machine {
    /**
     * Монеты в автомате.
     */
    private static int[] coins = new int[]{10, 5, 2, 1};

    /**
     * Метод выдачи сдачи для автомата.
     *
     * @param value внесли денег. 50 100 и тд.
     * @param price цена кофе.
     * @return массив монет.
     */
    public static int[] changes(int value, int price) throws NeedMoreMoneyException {
        if (value - price < 0) {
            throw new NeedMoreMoneyException();
        }
        int change = value - price;
        List<Integer> changeCoins = new ArrayList<>();
        while (change > 0) {
            for (int coin : coins) {
                if (change - coin >= 0) {
                    change -= coin;
                    changeCoins.add(coin);
                    break;
                }
            }
        }
        int[] changes = new int[changeCoins.size()];
        for (int i=0;i<changeCoins.size();i++){
            changes[i]=changeCoins.get(i);
        }
        return changes;
    }

}
