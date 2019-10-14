package ru.job4j.stream.address;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование методов работы с клиентами.
 *
 * @author Evgeny Novoselov
 */
public class ProfilesTest {
    /**
     * Тестирование получения уникальных адресов у клиентов.
     */
    @Test
    public void whenGetListAddressInProfilesThenUniqueListAddress() {
        List<Profile> profiles = Arrays.asList(
                new Profile(new Address("1", "1", 1, 1)),
                new Profile(new Address("1", "1", 1, 1)),
                new Profile(new Address("1", "1", 1, 2)),
                new Profile(new Address("1", "1", 1, 2)),
                new Profile(new Address("1", "1", 1, 3))
        );
        List<Address> expected = Arrays.asList(
                new Address("1", "1", 1, 1),
                new Address("1", "1", 1, 2),
                new Address("1", "1", 1, 3)
        );
        List<Address> addresses = Profiles.collect(profiles);
        assertThat(addresses, is(expected));
    }

    /**
     * Тестирование получения отсортированных адресов у клиентов.
     */
    @Test
    public void whenGetListAddressInProfilesThenSortListAddress() {
        List<Profile> profiles = Arrays.asList(
                new Profile(new Address("d", "1", 1, 1)),
                new Profile(new Address("b", "1", 1, 1)),
                new Profile(new Address("a", "1", 1, 1)),
                new Profile(new Address("c", "1", 1, 1))
        );
        List<Address> expected = Arrays.asList(
                new Address("a", "1", 1, 1),
                new Address("b", "1", 1, 1),
                new Address("c", "1", 1, 1),
                new Address("d", "1", 1, 1)
        );
        List<Address> addresses = Profiles.collect(profiles);
        assertThat(addresses, is(expected));
    }
}
