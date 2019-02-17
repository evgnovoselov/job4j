package ru.job4j.pseudo;

/**
 * Рисование фигуры.
 * Контекст.
 *
 * @author Evgeny Novoselov
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
