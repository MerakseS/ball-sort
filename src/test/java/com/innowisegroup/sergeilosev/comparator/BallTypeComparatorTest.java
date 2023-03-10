package com.innowisegroup.sergeilosev.comparator;

import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class BallTypeComparatorTest {

    private static Comparator<Ball> ballTypeComparator;

    @BeforeAll
    static void beforeAll() {
        ballTypeComparator = new BallTypeComparator();
    }

    @Test
    void firstBallTypeBiggerThanSecond() {
        Ball firstBall = new Ball(4, "Ping pong", Color.ORANGE);
        Ball secondBall = new Ball(78, "Basketball", Color.ORANGE);

        int result = ballTypeComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result > 0);
    }

    @Test
    void firstBallTypeSmallerThanSecond() {
        Ball firstBall = new Ball(66, "Football", Color.WHITE);
        Ball secondBall = new Ball(67, "Volleyball", Color.BLUE);

        int result = ballTypeComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result < 0);
    }

    @Test
    void firstBallTypeEqualsSecond() {
        Ball firstBall = new Ball(4, "Ping pong", Color.ORANGE);
        Ball secondBall = new Ball(4, "Ping pong", Color.WHITE);

        int result = ballTypeComparator.compare(firstBall, secondBall);

        Assertions.assertEquals(0, result);
    }
}