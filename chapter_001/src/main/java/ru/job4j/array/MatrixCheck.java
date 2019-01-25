package ru.job4j.array;

/**
 * Класс проверяет что все элементы по диагоналям равны true или false.
 *
 * @author Evgeny Novoselov
 */
public class MatrixCheck {
    /**
     * Метод проверяет, что все элементы по диагоналям равны true или false.
     *
     * @param data Матрица
     * @return Возвращает true если диагонали равные true или false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if ((data.length != data[i].length)
                    || (data[0][0] != data[i][i])
                    || (data[data.length - 1][0] != data[data.length - 1 - i][i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
