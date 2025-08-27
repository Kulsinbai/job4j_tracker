package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftLongerThanRightThenPositive() {
        StringCompare cmp = new StringCompare();
        int result = cmp.compare(
                "Ivanova",
                "Ivanov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenBothEmptyThenZero() {
        StringCompare cmp = new StringCompare();
        int result = cmp.compare(
                "",
                ""
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftEmptyThenNegative() {
        StringCompare cmp = new StringCompare();
        int result = cmp.compare(
                "",
                "А"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenRightEmptyThenPositive() {
        StringCompare cmp = new StringCompare();
        int result = cmp.compare(
                "А",
                ""
        );
        assertThat(result).isGreaterThan(0);
    }
}