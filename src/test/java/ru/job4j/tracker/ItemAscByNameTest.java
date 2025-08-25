package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
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

        Collections.sort(items, new ItemAscByName());

        List<Item> expected = Arrays.asList(
                new Item("Аня"),
                new Item("Борис"),
                new Item("Виктор")
        );

        assertEquals(expected, items);
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Борис"),
                new Item("Аня"),
                new Item("Виктор")
        );

        Collections.sort(items, new ItemDescByName());

        List<Item> expected = Arrays.asList(
                new Item("Виктор"),
                new Item("Борис"),
                new Item("Аня")
        );
    }
}