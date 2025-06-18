package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(int id) {
        int idx = indexOf(id);
        return idx != -1 ? items.get(idx) : null;
    }

    public boolean replace(int id, Item newItem) {
        int idx = indexOf(id);
            if (idx != -1) {
                newItem.setId(id);
                items.set(idx, newItem);
                return true;
            }
        return false;
    }

    public boolean delete(int id) {
        int idx = indexOf(id);
            if (idx != -1) {
                items.remove(idx);
                return true;
            }
        return false;
    }

    private int indexOf(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}