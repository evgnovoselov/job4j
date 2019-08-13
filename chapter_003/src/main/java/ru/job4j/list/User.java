package ru.job4j.list;

import java.util.Objects;

/**
 * Класс пользователя.
 *
 * @author Evgeny Novoselov
 */
public class User implements Comparable<User> {
    private static int counter;
    private final int id = counter++;
    private String name;
    private String city;
    private int age;

    public User(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", age='" + age + '\''
                + ", city='" + city + '\''
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
        User user = (User) o;
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(age, user.age)
                && Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, city);
    }

    @Override
    public int compareTo(User user) {
        return Integer.compare(this.age, user.age);
    }
}
