package com.innowisegroup.sergeilosev.model.impl;

import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;

public class Football extends Ball {

    private static final int DEFAULT_FOOTBALL_SIZE = 66;
    private static final Color DEFAULT_FOOTBALL_COLOR = Color.WHITE;

    public Football() {
        super(DEFAULT_FOOTBALL_SIZE, DEFAULT_FOOTBALL_COLOR);
    }

    public Football(int size) {
        super(size, DEFAULT_FOOTBALL_COLOR);
    }

    public Football(Color color) {
        super(DEFAULT_FOOTBALL_SIZE, color);
    }

    public Football(int size, Color color) {
        super(size, color);
    }

    @Override
    public String toString() {
        return "Football{" +
                "size=" + size +
                ", color=" + color +
                '}';
    }
}
