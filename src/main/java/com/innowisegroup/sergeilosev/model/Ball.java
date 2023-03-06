package com.innowisegroup.sergeilosev.model;

import java.util.Objects;

public abstract class Ball {
    protected final int size;
    protected final Color color;

    protected Ball(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return size == ball.size && color == ball.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, color);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "size=" + size +
                ", color=" + color +
                '}';
    }
}
