package com.innowisegroup.sergeilosev.model;

public record Ball(int size, String ballType, Color color) implements Comparable<Ball> {

    @Override
    public int compareTo(Ball ball) {
        int ballTypeCompare = this.ballType().compareTo(ball.ballType());
        if (ballTypeCompare != 0) {
            return ballTypeCompare;
        }

        int sizeCompare = Integer.compare(this.size(), ball.size());
        if (sizeCompare != 0) {
            return sizeCompare;
        }

        return this.color().compareTo(ball.color());
    }
}
