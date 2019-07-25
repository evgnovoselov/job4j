package ru.job4j.loop;

/**
 * Класс для расчета сколько месяцев Ивану нужно тренироваться, чтобы обогнать Николая в тяге.
 * Иван за месяц увеличивает силу тяги в 3 раза за счет диеты, а Николай - за месяц увеличивает силу тяги в 2 раза.
 *
 * @author Evgeny Novoselov
 */
public class Fitness {
    public int calc(int ivan, int nik) {
        int month = 0;
        while (ivan < nik) {
            month++;
            ivan *= 3;
            nik *= 2;
        }
        return month;
    }
}
