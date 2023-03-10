package com.innowisegroup.sergeilosev;

import com.innowisegroup.sergeilosev.comparator.BallColorComparator;
import com.innowisegroup.sergeilosev.comparator.BallSizeComparator;
import com.innowisegroup.sergeilosev.comparator.BallTypeComparator;
import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;
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
                new Ball(65, "Football", Color.WHITE),
                new Ball(4, "Ping pong", Color.ORANGE),
                new Ball(76, "Basketball", Color.WHITE),
                new Ball(68, "Volleyball", Color.BLUE),
                new Ball(4, "Ping pong", Color.WHITE),
                new Ball(66, "Volleyball", Color.GREEN)
        );
    }

    @Test
    void sortBallsBySize() {
        Comparator<Ball> comparator = new BallSizeComparator();

        List<Ball> expectedBallList = Arrays.asList(
                new Ball(4, "Ping pong", Color.WHITE),
                new Ball(4, "Ping pong", Color.ORANGE),
                new Ball(65, "Football", Color.WHITE),
                new Ball(66, "Volleyball", Color.GREEN),
                new Ball(68, "Volleyball", Color.BLUE),
                new Ball(76, "Basketball", Color.WHITE)
        );

        actualBallList = mergeSort.sort(actualBallList, comparator);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void sortBallsByColor() {
        Comparator<Ball> comparator = new BallColorComparator();

        List<Ball> expectedBallList = Arrays.asList(
                new Ball(4, "Ping pong", Color.WHITE),
                new Ball(76, "Basketball", Color.WHITE),
                new Ball(65, "Football", Color.WHITE),
                new Ball(68, "Volleyball", Color.BLUE),
                new Ball(4, "Ping pong", Color.ORANGE),
                new Ball(66, "Volleyball", Color.GREEN)
        );

        actualBallList = mergeSort.sort(actualBallList, comparator);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void sortBallsByClass() {
        Comparator<Ball> comparator = new BallTypeComparator();

        List<Ball> expectedBallList = Arrays.asList(
                new Ball(76, "Basketball", Color.WHITE),
                new Ball(65, "Football", Color.WHITE),
                new Ball(4, "Ping pong", Color.WHITE),
                new Ball(4, "Ping pong", Color.ORANGE),
                new Ball(66, "Volleyball", Color.GREEN),
                new Ball(68, "Volleyball", Color.BLUE)
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
                new Ball(76, "Basketball", Color.WHITE),
                new Ball(68, "Volleyball", Color.BLUE),
                new Ball(66, "Volleyball", Color.GREEN),
                new Ball(65, "Football", Color.WHITE),
                new Ball(4, "Ping pong", Color.ORANGE),
                new Ball(4, "Ping pong", Color.WHITE)
        );

        actualBallList = mergeSort.sort(actualBallList, comparator);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }

    @Test
    void sortBallsWithoutComparator() {
        List<Ball> expectedBallList = Arrays.asList(
                new Ball(76, "Basketball", Color.WHITE),
                new Ball(65, "Football", Color.WHITE),
                new Ball(4, "Ping pong", Color.WHITE),
                new Ball(4, "Ping pong", Color.ORANGE),
                new Ball(66, "Volleyball", Color.GREEN),
                new Ball(68, "Volleyball", Color.BLUE)
        );

        actualBallList = mergeSort.sort(actualBallList);

        Assertions.assertEquals(expectedBallList, actualBallList);
    }
}
