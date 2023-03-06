package com.innowisegroup.sergeilosev.model;

public enum Color {
    WHITE("White"),
    BLUE("Blue"),
    ORANGE("Orange"),
    GREEN("Green");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
