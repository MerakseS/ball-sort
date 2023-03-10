package com.innowisegroup.sergeilosev.comparator;

import com.innowisegroup.sergeilosev.model.Ball;

import java.util.Comparator;

public class BallTypeComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball ball1, Ball ball2) {
        return ball1.ballType().compareTo(ball2.ballType());
    }
}
