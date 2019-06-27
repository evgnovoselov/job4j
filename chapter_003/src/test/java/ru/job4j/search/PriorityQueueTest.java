package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса агрегатора задач по приоритету.
 *
 * @author Evgeny Novoselov
 */
public class PriorityQueueTest {
    /**
     * Тестирование получения задачи с высшим приоритетом.
     */
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("very-low", 8));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}
