package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    void whenListSorted() {
        List<Item> items = new ArrayList<>(List.of(
                new Item("Ben"),
                new Item("Zack"),
                new Item("Adam"),
                new Item("Deny")));
        List<Item> expected = new ArrayList<>(List.of(
                new Item("Zack"),
                new Item("Deny"),
                new Item("Ben"),
                new Item("Adam")));
        items.sort(new ItemDescByName());
        assertThat(items.equals(expected)).isTrue();
    }
}