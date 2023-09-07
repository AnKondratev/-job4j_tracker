package ru.job4j.encapsulation;

public class Config {
    private String name;
    private int position;
    private String[] properties;

    public Config(String name, int position, String[] properties) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void print() {
        System.out.println(position);
    }

    public String getProperty(String key) {
        return search(key);
    }

    private String search(String key) {
        return key;
    }
}