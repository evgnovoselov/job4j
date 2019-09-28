package ru.job4j.exam;

import java.util.TreeMap;

/**
 * Организация содержащая департаменты.
 *
 * @author Evgeny Novoselov
 */
public class Organization {
    TreeMap<String, String> departments = new TreeMap<>();

    public Organization(String[] departments) {
    }
}