package com.innowisegroup.sergeilosev.comparator;

import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class BallColorComparatorTest {

    private static Comparator<Ball> ballColorComparator;

    @BeforeAll
    static void beforeAll() {
        ballColorComparator = new BallColorComparator();
    }

    @Test
    void firstBallColorBiggerThanSecond() {
        Ball firstBall = new Ball(4, "Ping pong", Color.ORANGE);
        Ball secondBall = new Ball(4, "Ping pong", Color.WHITE);

        int result = ballColorComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result > 0);
    }

    @Test
    void firstBallColorSmallerThanSecond() {
        Ball firstBall = new Ball(66, "Volleyball", Color.BLUE);
        Ball secondBall = new Ball(66, "Volleyball", Color.GREEN);

        int result = ballColorComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result < 0);
    }

    @Test
    void firstBallColorEqualsSecond() {
        Ball firstBall = new Ball(4, "Ping pong", Color.ORANGE);
        Ball secondBall = new Ball(78, "Basketball", Color.ORANGE);

        int result = ballColorComparator.compare(firstBall, secondBall);

        Assertions.assertEquals(0, result);
    }
}