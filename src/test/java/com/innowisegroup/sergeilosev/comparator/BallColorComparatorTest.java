package com.innowisegroup.sergeilosev.comparator;

import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;
import com.innowisegroup.sergeilosev.model.impl.Basketball;
import com.innowisegroup.sergeilosev.model.impl.PingPongBall;
import com.innowisegroup.sergeilosev.model.impl.Volleyball;
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
        Ball firstBall = new PingPongBall(Color.ORANGE);
        Ball secondBall = new PingPongBall(Color.WHITE);

        int result = ballColorComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result > 0);
    }

    @Test
    void firstBallColorSmallerThanSecond() {
        Ball firstBall = new Volleyball(Color.BLUE);
        Ball secondBall = new Volleyball(Color.GREEN);

        int result = ballColorComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result < 0);
    }

    @Test
    void firstBallColorEqualsSecond() {
        Ball firstBall = new PingPongBall(Color.ORANGE);
        Ball secondBall = new Basketball();

        int result = ballColorComparator.compare(firstBall, secondBall);

        Assertions.assertEquals(0, result);
    }
}