package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Компаратор для сравнения двух массивов символов.
 *
 * @author Evgeny Novoselov
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        int result = 0;
        for (int i = 0; i < s.length() - 1 || i < t1.length() - 1; i++) {
            char cs = s.charAt(i);
            char ct1 = t1.charAt(i);
            if (cs != ct1) {
                result = Character.compare(cs, ct1);
                break;
            }
        }
        return (result == 0 && s.length() != t1.length()) ? Integer.compare(s.length(), t1.length()) : result;
    }
}
