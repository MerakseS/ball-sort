package com.innowisegroup.sergeilosev.model.impl;

import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;

public class Volleyball extends Ball {

    private static final int DEFAULT_VOLLEYBALL_SIZE = 67;
    private static final Color DEFAULT_VOLLEYBALL_COLOR = Color.BLUE;

    public Volleyball() {
        super(DEFAULT_VOLLEYBALL_SIZE, DEFAULT_VOLLEYBALL_COLOR);
    }

    public Volleyball(Color color) {
        super(DEFAULT_VOLLEYBALL_SIZE, color);
    }

    @Override
    public String toString() {
        return "Volleyball{" +
                "size=" + size +
                ", color=" + color +
                '}';
    }
}
