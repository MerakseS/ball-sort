package com.innowisegroup.sergeilosev.comparator;

import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;
import com.innowisegroup.sergeilosev.model.impl.Basketball;
import com.innowisegroup.sergeilosev.model.impl.Football;
import com.innowisegroup.sergeilosev.model.impl.PingPongBall;
import com.innowisegroup.sergeilosev.model.impl.Volleyball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class BallClassComparatorTest {

    private static Comparator<Ball> ballClassComparator;

    @BeforeAll
    static void beforeAll() {
        ballClassComparator = new BallClassComparator();
    }

    @Test
    void firstBallClassBiggerThanSecond() {
        Ball firstBall = new PingPongBall();
        Ball secondBall = new Basketball();

        int result = ballClassComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result > 0);
    }

    @Test
    void firstBallClassSmallerThanSecond() {
        Ball firstBall = new Football();
        Ball secondBall = new Volleyball();

        int result = ballClassComparator.compare(firstBall, secondBall);

        Assertions.assertTrue(result < 0);
    }

    @Test
    void firstBallClassEqualsSecond() {
        Ball firstBall = new PingPongBall(Color.ORANGE);
        Ball secondBall = new PingPongBall(Color.WHITE);

        int result = ballClassComparator.compare(firstBall, secondBall);

        Assertions.assertEquals(0, result);
    }
}