package com.innowisegroup.sergeilosev.comparator;

import com.innowisegroup.sergeilosev.model.Ball;

import java.util.Comparator;

public class BallClassComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball ball1, Ball ball2) {
        String className1 = ball1.getClass().getName();
        String className2 = ball2.getClass().getName();

        return className1.compareTo(className2);
    }
}
