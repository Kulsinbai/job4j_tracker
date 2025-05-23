package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                return i;
            }
        }

        throw new ElementNotFoundException("Элемент не найден: " + key);
    }

    public static void main(String[] args) {
        String[] team = {"Arsenal", "Liverpool", "Chelsea"};
        String key = "Real Madrid";

        try {
            int index = indexOf(team, key);
            System.out.println("Элемент найден. Индекс: " + index);
        } catch (ElementNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}