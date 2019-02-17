package ru.job4j.pseudo;

/**
 * Класс демонстрации патерна стратегии
 * с рисованием квардрата и треугольника
 *
 * @author Evgeny Novoselov
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Paint paint = new Paint();

        paint.draw(new Square());

        paint.draw(new Triangle());
    }
}
