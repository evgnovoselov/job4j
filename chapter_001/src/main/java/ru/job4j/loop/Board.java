package ru.job4j.loop;

/**
 * Класс имитации шахматной доски.
 *
 * @author Evgeny Novoselov
 */
public class Board {
    /**
     * Рисуем шахматную доску.
     * Псевдографикой с символом X.
     *
     * @param width  ширина доски.
     * @param height высота доски.
     * @return Возвращаем строковое представление доски
     */
    public String paint(int width, int height) {
        StringBuilder board = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    board.append("X");
                } else {
                    board.append(" ");
                }
            }
            board.append(ln);
        }
        return board.toString();
    }
}
