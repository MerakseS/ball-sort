package com.innowisegroup.sergeilosev.comparator;

import com.innowisegroup.sergeilosev.model.Ball;

import java.util.Comparator;

public class BallColorComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball ball1, Ball ball2) {
        return ball1.getColor().compareTo(ball2.getColor());
    }
}
