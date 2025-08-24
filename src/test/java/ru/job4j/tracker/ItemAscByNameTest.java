package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemAscByNameTest {
    @Test
    public void whenSortAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Борис"),
                new Item("Аня"),
                new Item("Виктор")
        );

        items.sort(new ItemAscByName());

        List<String> actual = new ArrayList<>();
        for (Item it : items) {
            actual.add(it.getName());
        }

        List<String> expected = Arrays.asList("Аня", "Борис", "Виктор");

        assertEquals(expected, actual);
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Борис"),
                new Item("Аня"),
                new Item("Виктор")
        );

        items.sort(new ItemDescByName());

        List<String> actual = new ArrayList<>();
        for (Item it : items) {
            actual.add(it.getName());
        }

        List<String> expected = Arrays.asList("Виктор", "Борис", "Аня");

        assertEquals(expected, actual);
    }
}