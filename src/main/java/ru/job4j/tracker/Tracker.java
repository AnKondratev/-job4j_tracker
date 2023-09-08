package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        size = 0;
        for (Item item : items) {
            if (item != null) {
                result[size++] = item;
            }
        }

        return Arrays.copyOf(result, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                result[count++] = items[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        for (int i = 0; i < size; i++) {
            if (indexOf(id) != -1 && id == items[i].getId()) {
                items[indexOf(id)].setName(item.getName());
            } else {
                return false;
            }
        }
        return true;
    }

    public void delete(int id) {
        int index = indexOf(id);
        for (int i = 0; i < size; i++) {
            if (index != -1 && id == items[i].getId()) {
                System.arraycopy(items, index + 1, items, index, size - (index - 1));
                items[size - 1] = null;
                size--;
            }
        }
    }
}



