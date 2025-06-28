package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mail = new HashMap<>();
        mail.put("kulsinbai@mail.ru", "Ilyas Kulsinbaev");
        mail.put("biktairiva@mail.ru", "Elena Biktairova");
        mail.put("smakov@mail.ru", "Pavel Smakov");
        mail.put("kulsinbai@mail.ru", "Ilyas Kulsinbai");

        for (String key : mail.keySet()) {
            String value = mail.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
