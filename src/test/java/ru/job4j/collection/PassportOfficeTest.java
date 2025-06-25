package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddDuplicateThenReturnFalse() {
        Citizen first = new Citizen("2f44a", "Petr Arsentev");
        Citizen second = new Citizen("2f44a", "Ilyas Kulsinbai");
        PassportOffice office = new PassportOffice();
        boolean addedFirst = office.add(first);
        boolean addedSecond = office.add(second);
        assertThat(addedFirst).isTrue();
        assertThat(addedSecond).isFalse();
    }
}