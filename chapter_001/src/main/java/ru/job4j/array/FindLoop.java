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

    /**
     * Метод поиска элемента в массиве по указанному диапозону.
     * Если элемента нет в массиве, то возвращаем -1.
     *
     * @param data   Массив чисел.
     * @param el     Элемент, который нужно найти.
     * @param start  Индекс, с которого начинаем поиск.
     * @param finish Индекс, которым заканчиваем поиск.
     * @return Возвращаем индекс найденного элемента, в противном случае -1.
     */
    public int indexOf(int[] data, int el, int start, int finish) {
        int result = -1;
        if (start >= data.length) {
            start = data.length - 1;
        }
        if (finish >= data.length) {
            finish = data.length - 1;
        }
        for (int i = start; i <= finish; i++) {
            if (data[i] == el) {
                result = i;
                break;
            }
        }
        return result;
    }
}
