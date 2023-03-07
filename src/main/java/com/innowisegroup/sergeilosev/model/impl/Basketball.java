package com.innowisegroup.sergeilosev.model.impl;

import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;

public class Basketball extends Ball {

    private static final int DEFAULT_BASKETBALL_SIZE = 78;
    private static final Color DEFAULT_BASKETBALL_COLOR = Color.ORANGE;

    public Basketball() {
        super(DEFAULT_BASKETBALL_SIZE, DEFAULT_BASKETBALL_COLOR);
    }

    public Basketball(int size) {
        super(size, DEFAULT_BASKETBALL_COLOR);
    }

    public Basketball(Color color) {
        super(DEFAULT_BASKETBALL_SIZE, color);
    }

    public Basketball(int size, Color color) {
        super(size, color);
    }

    @Override
    public String toString() {
        return "Basketball{" +
                "size=" + size +
                ", color=" + color +
                '}';
    }
}
