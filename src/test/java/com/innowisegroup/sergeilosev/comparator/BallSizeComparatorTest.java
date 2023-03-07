package com.innowisegroup.sergeilosev.comparator;

import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;
import com.innowisegroup.sergeilosev.model.impl.Basketball;
import com.innowisegroup.sergeilosev.model.impl.Football;
import com.innowisegroup.sergeilosev.model.impl.PingPongBall;
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
        Ball firstBall = new Basketball();
        Ball secondBall = new PingPongBall();

        int result = ballSizeComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result > 0);
    }

    @Test
    void firstBallSizeSmallerThanSecond() {
        Ball firstBall = new Football();
        Ball secondBall = new Basketball();

        int result = ballSizeComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result < 0);
    }

    @Test
    void firstBallSizeEqualsSecond() {
        Ball firstBall = new PingPongBall(Color.ORANGE);
        Ball secondBall = new PingPongBall(Color.WHITE);

        int result = ballSizeComparator.compare(firstBall, secondBall);

        Assertions.assertEquals(0, result);
    }
}