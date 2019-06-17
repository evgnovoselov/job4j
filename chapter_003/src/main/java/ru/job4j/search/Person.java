package ru.job4j.search;

/**
 * Карточка человека.
 *
 * @author Evgeny Novoselov
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    /**
     * Конструктор записи информации о человеке.
     *
     * @param name    Имя.
     * @param surname Фамилия.
     * @param phone   Телефон.
     * @param address Адрес.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
