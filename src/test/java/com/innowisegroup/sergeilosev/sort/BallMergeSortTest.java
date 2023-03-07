package com.innowisegroup.sergeilosev.sort;

import com.innowisegroup.sergeilosev.comparator.BallColorComparator;
import com.innowisegroup.sergeilosev.comparator.BallSizeComparator;
import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;
import com.innowisegroup.sergeilosev.model.impl.Basketball;
import com.innowisegroup.sergeilosev.model.impl.Football;
import com.innowisegroup.sergeilosev.model.impl.PingPongBall;
import com.innowisegroup.sergeilosev.model.impl.Volleyball;
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
                new Football(),
                new PingPongBall(Color.ORANGE),
                new Basketball(),
                new Volleyball(),
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
                new Football(),
                new Volleyball(Color.GREEN),
                new Volleyball(),
                new Basketball()
        );

        actualBallList = mergeSort.sort(actualBallList, comparator);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void sortBallsByColor() {
        Comparator<Ball> comparator = new BallColorComparator();

        List<Ball> expectedBallList = Arrays.asList(
                new PingPongBall(),
                new Football(),
                new Volleyball(),
                new Basketball(),
                new PingPongBall(Color.ORANGE),
                new Volleyball(Color.GREEN)
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
                new Basketball(),
                new Volleyball(Color.GREEN),
                new Volleyball(),
                new Football(),
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
                new Football(),
                new Volleyball(),
                new Volleyball(Color.GREEN),
                new Basketball()
        );

        actualBallList = mergeSort.sort(actualBallList);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }
}
