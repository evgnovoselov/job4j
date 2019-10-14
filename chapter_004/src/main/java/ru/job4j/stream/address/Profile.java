package ru.job4j.stream.address;

/**
 * Анкета клиента.
 *
 * @author Evgeny Novoselov
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
