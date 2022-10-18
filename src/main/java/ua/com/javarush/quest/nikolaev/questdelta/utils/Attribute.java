package ua.com.javarush.quest.nikolaev.questdelta.utils;

public enum Attribute {
    ERROR("error"),
    USER("user"),
    ROLE("role"),
    USERS("users"),
    PAGE_COUNT("pageCount"),
    PAGE_NUMBER("page");


    private final String value;

    Attribute(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }
}