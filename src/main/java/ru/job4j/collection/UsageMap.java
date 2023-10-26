package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("kondratev.an@inbox.ru", "Andrey Kondratev");
        map.put("kondratev.an@inbox.ru", "Andrey Kondratev");
        map.put("ivanov.ivan@mail.ru", "Ivanov Ivan");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " | " + value);
        }
    }
}
