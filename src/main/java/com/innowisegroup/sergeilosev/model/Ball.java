package com.innowisegroup.sergeilosev.model;

import java.util.Objects;

public abstract class Ball implements Comparable<Ball> {

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
    public int compareTo(Ball ball) {
        int sizeCompare = Integer.compare(size, ball.getSize());
        return sizeCompare != 0 ? sizeCompare : color.compareTo(ball.getColor());
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
}
