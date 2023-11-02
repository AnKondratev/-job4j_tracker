package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void whenListSorted() {
        List<Item> items = new ArrayList<>(List.of(
                new Item("Ben"),
                new Item("Zack"),
                new Item("Adam"),
                new Item("Deny")));
        List<Item> expected = new ArrayList<>(List.of(
                new Item("Adam"),
                new Item("Ben"),
                new Item("Deny"),
                new Item("Zack")));
        items.sort(new ItemAscByName());
        assertThat(items).usingRecursiveFieldByFieldElementComparatorOnFields("name")
                .containsExactlyElementsOf(expected);
    }
}