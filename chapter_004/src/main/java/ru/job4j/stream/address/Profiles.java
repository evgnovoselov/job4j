package ru.job4j.stream.address;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для работы с клиентами.
 *
 * @author Evgeny Novoselov
 */
public class Profiles {
    /**
     * Метод получает список адресов у клиентов.
     *
     * @param profiles клиенты.
     * @return возвращаем список адресов.
     */
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(
                Profile::getAddress
        ).collect(Collectors.toList());
    }
}
