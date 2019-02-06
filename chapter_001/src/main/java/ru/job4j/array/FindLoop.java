package ru.job4j.array;

/**
 * Класс поиска элемента в массиве
 *
 * @author Evgeny Novoselov
 */
public class FindLoop {
    /**
     * Метод поиска элемента в массиве.
     * Если элемента нет в массиве, то возвращаем -1.
     *
     * @param data Массив
     * @param el   Искомый элемент
     * @return Возвращаем индекс найденного элемента, в противном случае -1
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
