package ru.job4j.stream.school;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс учеников с общим балом по предметам.
 *
 * @author Evgeny Novoselov
 */
public class Student implements Comparable<Student> {
    private String surname;
    private int score;

    private static long unknownId = 1;

    public Student(int score) {
        this(String.format("Unknown%s", unknownId), score);
        unknownId++;
    }

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{"
                + "surname='" + surname + '\''
                + ", score=" + score
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname);
    }

    @Override
    public int compareTo(Student o) {
        return surname.compareToIgnoreCase(o.surname);
    }

    /**
     * Метод возвращает список студентов у которых балл аттестата больше bound.
     *
     * @param students Список студентов.
     * @param bound    Балл для фильтрации.
     * @return Список студентов у которых балл выше bound.
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(student -> student.score >= bound)
                .collect(Collectors.toList());
    }
}
