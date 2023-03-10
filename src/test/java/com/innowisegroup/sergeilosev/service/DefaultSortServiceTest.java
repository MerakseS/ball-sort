package com.innowisegroup.sergeilosev.service;

import com.innowisegroup.sergeilosev.comparator.BallColorComparator;
import com.innowisegroup.sergeilosev.comparator.BallSizeComparator;
import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;
import com.innowisegroup.sergeilosev.sort.impl.HeapSort;
import com.innowisegroup.sergeilosev.sort.impl.MergeSort;
import com.innowisegroup.sergeilosev.sort.impl.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class DefaultSortServiceTest {

    private static SortService sortService;

    private List<Ball> actualBallList;

    @BeforeAll
    static void beforeAll() {
        sortService = new DefaultSortService();
    }

    @BeforeEach
    void setUp() {
        actualBallList = Arrays.asList(
                new Ball(65, "Football", Color.WHITE),
                new Ball(4, "Ping pong", Color.ORANGE),
                new Ball(76, "Basketball", Color.WHITE),
                new Ball(68, "Volleyball", Color.BLUE),
                new Ball(4, "Ping pong", Color.WHITE),
                new Ball(66, "Volleyball", Color.GREEN)
        );
    }

    @Test
    void quickSortWithNoComparator() {
        List<Ball> expectedBallList = Arrays.asList(
                new Ball(76, "Basketball", Color.WHITE),
                new Ball(65, "Football", Color.WHITE),
                new Ball(4, "Ping pong", Color.WHITE),
                new Ball(4, "Ping pong", Color.ORANGE),
                new Ball(66, "Volleyball", Color.GREEN),
                new Ball(68, "Volleyball", Color.BLUE)
        );

        actualBallList = sortService.sort(actualBallList, new QuickSort());

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void heapSortBallsBySizeAndColorReversed() {
        List<Ball> expectedBallList = Arrays.asList(
                new Ball(76, "Basketball", Color.WHITE),
                new Ball(68, "Volleyball", Color.BLUE),
                new Ball(66, "Volleyball", Color.GREEN),
                new Ball(65, "Football", Color.WHITE),
                new Ball(4, "Ping pong", Color.ORANGE),
                new Ball(4, "Ping pong", Color.WHITE)
        );

        Comparator<Ball> comparator = new BallSizeComparator()
                .thenComparing(new BallColorComparator())
                .reversed();

        actualBallList = sortService.sort(actualBallList, new HeapSort(), comparator);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void sortBallsByColor() {
        List<Ball> expectedBallList = Arrays.asList(
                new Ball(4, "Ping pong", Color.WHITE),
                new Ball(76, "Basketball", Color.WHITE),
                new Ball(65, "Football", Color.WHITE),
                new Ball(68, "Volleyball", Color.BLUE),
                new Ball(4, "Ping pong", Color.ORANGE),
                new Ball(66, "Volleyball", Color.GREEN)
        );

        actualBallList = sortService.sort(actualBallList, new MergeSort(), new BallColorComparator());

        Assertions.assertEquals(expectedBallList, actualBallList);
    }
}