package ru.job4j.pseudo;

/**
 * Класс рисования квадрата.
 *
 * @author Evgeny Novoselov
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++++++").append(System.lineSeparator());
        pic.append("+      +").append(System.lineSeparator());
        pic.append("+      +").append(System.lineSeparator());
        pic.append("++++++++").append(System.lineSeparator());
        return pic.toString();
    }
}
