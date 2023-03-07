package com.innowisegroup.sergeilosev;

import com.innowisegroup.sergeilosev.comparator.BallClassComparator;
import com.innowisegroup.sergeilosev.comparator.BallColorComparator;
import com.innowisegroup.sergeilosev.comparator.BallSizeComparator;
import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;
import com.innowisegroup.sergeilosev.model.impl.Basketball;
import com.innowisegroup.sergeilosev.model.impl.Football;
import com.innowisegroup.sergeilosev.model.impl.PingPongBall;
import com.innowisegroup.sergeilosev.model.impl.Volleyball;
import com.innowisegroup.sergeilosev.sort.Sort;
import com.innowisegroup.sergeilosev.sort.impl.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BallMergeSortTest {

    private static Sort mergeSort;

    private List<Ball> actualBallList;

    @BeforeAll
    static void beforeAll() {
        mergeSort = new MergeSort();
    }

    @BeforeEach
    void setUp() {
        actualBallList = Arrays.asList(
                new Football(65),
                new PingPongBall(Color.ORANGE),
                new Basketball(76, Color.WHITE),
                new Volleyball(68),
                new PingPongBall(),
                new Volleyball(Color.GREEN)
        );
    }

    @Test
    void sortBallsBySize() {
        Comparator<Ball> comparator = new BallSizeComparator();

        List<Ball> expectedBallList = Arrays.asList(
                new PingPongBall(),
                new PingPongBall(Color.ORANGE),
                new Football(65),
                new Volleyball(Color.GREEN),
                new Volleyball(68),
                new Basketball(76, Color.WHITE)
        );

        actualBallList = mergeSort.sort(actualBallList, comparator);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void sortBallsByColor() {
        Comparator<Ball> comparator = new BallColorComparator();

        List<Ball> expectedBallList = Arrays.asList(
                new PingPongBall(),
                new Basketball(76, Color.WHITE),
                new Football(65),
                new Volleyball(68),
                new PingPongBall(Color.ORANGE),
                new Volleyball(Color.GREEN)
        );

        actualBallList = mergeSort.sort(actualBallList, comparator);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void sortBallsByClass() {
        Comparator<Ball> comparator = new BallClassComparator();

        List<Ball> expectedBallList = Arrays.asList(
                new Basketball(76, Color.WHITE),
                new Football(65),
                new PingPongBall(),
                new PingPongBall(Color.ORANGE),
                new Volleyball(Color.GREEN),
                new Volleyball(68)
        );

        actualBallList = mergeSort.sort(actualBallList, comparator);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void sortBallsBySizeAndColorReversed() {
        Comparator<Ball> comparator = new BallSizeComparator()
                .thenComparing(new BallColorComparator())
                .reversed();

        List<Ball> expectedBallList = Arrays.asList(
                new Basketball(76, Color.WHITE),
                new Volleyball(68),
                new Volleyball(Color.GREEN),
                new Football(65),
                new PingPongBall(Color.ORANGE),
                new PingPongBall()
        );

        actualBallList = mergeSort.sort(actualBallList, comparator);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void sortBallsWithoutComparator() {
        List<Ball> expectedBallList = Arrays.asList(
                new PingPongBall(),
                new PingPongBall(Color.ORANGE),
                new Football(65),
                new Volleyball(Color.GREEN),
                new Volleyball(68),
                new Basketball(76, Color.WHITE)
        );

        actualBallList = mergeSort.sort(actualBallList);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }
}
