package ua.com.javarush.quest.nikolaev.questdelta.utils;

public enum Attribute {
    ERROR("error"),
    USER("user"),
    ROLE("role"),
    USERS("users");

    private final String name;

    Attribute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}