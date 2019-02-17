package ru.job4j.pseudo;

/**
 * Класс рисования треугольника.
 *
 * @author Evgeny Novoselov
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +\n");
        pic.append("  +++\n");
        pic.append(" +++++\n");
        pic.append("+++++++\n");
        return pic.toString();
    }
}
