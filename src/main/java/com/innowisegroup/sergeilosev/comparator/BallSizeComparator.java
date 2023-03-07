package com.innowisegroup.sergeilosev.comparator;

import com.innowisegroup.sergeilosev.model.Ball;

import java.util.Comparator;

public class BallSizeComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball ball1, Ball ball2) {
        return Integer.compare(ball1.getSize(), ball2.getSize());
    }
}
