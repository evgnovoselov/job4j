package ru.job4j.condition;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Тест класса точки
 */
public class PointTest {
    /**
     * Тест метода расчета расстояния от точки до точки.
     */
    @Test
    public void whenPointX1Y1DistanceToPointX100Y100Then140() {
        Point a = new Point(1, 1);
        assertThat(a.distanceTo(new Point(100, 100)), closeTo(140, 0.01));
    }
}
