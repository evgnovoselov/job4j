package ru.job4j.condition;

/**
 * Класс Point описывает точку в системе координат.
 *
 * @author Evgeny Novoselov
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор класса Point.
     *
     * @param x Абсцисса.
     * @param y Ордината.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод вычисления расстояние до другой точки.
     *
     * @param that Точка
     * @return Дистанция до точки that
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(100, 100);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
