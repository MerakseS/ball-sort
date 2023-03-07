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
import com.innowisegroup.sergeilosev.sort.impl.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BallHeapSortTest {

    private static Sort heapSort;

    private List<Ball> actualBallList;

    @BeforeAll
    static void beforeAll() {
        heapSort = new QuickSort();
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
                new PingPongBall(Color.ORANGE),
                new PingPongBall(),
                new Football(65),
                new Volleyball(Color.GREEN),
                new Volleyball(68),
                new Basketball(76, Color.WHITE)
        );

        heapSort.sort(actualBallList, comparator);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void sortBallsByColor() {
        Comparator<Ball> comparator = new BallColorComparator();

        List<Ball> expectedBallList = Arrays.asList(
                new Basketball(76, Color.WHITE),
                new PingPongBall(),
                new Football(65),
                new Volleyball(68),
                new PingPongBall(Color.ORANGE),
                new Volleyball(Color.GREEN)
        );

        heapSort.sort(actualBallList, comparator);

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

        actualBallList = heapSort.sort(actualBallList, comparator);

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

        heapSort.sort(actualBallList, comparator);

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

        heapSort.sort(actualBallList);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }
}
