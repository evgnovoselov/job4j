package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Консольный ввод параметров.
 *
 * @author Evgeny Novoselov
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Метод задает вопрос и возвращает ответ.
     *
     * @param question вопрос.
     * @param range    возможный ответ.
     * @return возвращает введенный ответ.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Данного раздела меню не существует");
        }
        return key;
    }
}
