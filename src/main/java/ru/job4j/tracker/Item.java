package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Item item1 = new Item();
        item1.setId(1);
        item1.setName("Hello");
        System.out.println("Item 1: id = " + item1.getId() + ", name = " + item1.getName());
        Item item2 = new Item();
        item2.setId(2);
        System.out.println("Item 2: id = " + item2.getId() + ", name = " + item2.getName());
        Item item3 = new Item(3, "Привет");
        System.out.println("Item 3: id = " + item3.getId() + ", name = " + item3.getName());
    }
}