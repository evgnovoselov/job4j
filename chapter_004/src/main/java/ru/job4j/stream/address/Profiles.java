package ru.job4j.stream.address;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для работы с клиентами.
 *
 * @author Evgeny Novoselov
 */
public class Profiles {
    /**
     * Метод получает уникальных и отсортированных адресов у клиентов.
     *
     * @param profiles клиенты.
     * @return возвращаем список адресов.
     */
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(
                Profile::getAddress
        ).sorted(new Comparator<Address>() {
            @Override
            public int compare(Address address, Address t1) {
                return address.getCity().compareToIgnoreCase(t1.getCity());
            }
        }).distinct().collect(Collectors.toList());
    }
}
