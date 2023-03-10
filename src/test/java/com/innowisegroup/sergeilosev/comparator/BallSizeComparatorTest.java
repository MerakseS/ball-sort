package com.innowisegroup.sergeilosev.comparator;

import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class BallSizeComparatorTest {

    private static Comparator<Ball> ballSizeComparator;

    @BeforeAll
    static void beforeAll() {
        ballSizeComparator = new BallSizeComparator();
    }

    @Test
    void firstBallSizeBiggerThanSecond() {
        Ball firstBall = new Ball(78, "Basketball", Color.ORANGE);
        Ball secondBall = new Ball(4, "Ping pong", Color.WHITE);

        int result = ballSizeComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result > 0);
    }

    @Test
    void firstBallSizeSmallerThanSecond() {
        Ball firstBall = new Ball(66, "Football", Color.WHITE);
        Ball secondBall = new Ball(78, "Basketball", Color.ORANGE);

        int result = ballSizeComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result < 0);
    }

    @Test
    void firstBallSizeEqualsSecond() {
        Ball firstBall = new Ball(4, "Ping pong", Color.ORANGE);
        Ball secondBall = new Ball(4, "Ping pong", Color.WHITE);

        int result = ballSizeComparator.compare(firstBall, secondBall);

        Assertions.assertEquals(0, result);
    }
}