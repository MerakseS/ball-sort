package com.innowisegroup.sergeilosev.sort;

import com.innowisegroup.sergeilosev.sort.impl.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MergeSortTest {

    private static Sort mergeSort;

    @BeforeAll
    static void beforeAll() {
        mergeSort = new MergeSort();
    }

    @Test
    void nullList() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> mergeSort.sort(null));
    }

    @Test
    void zeroItems() {
        List<Integer> list = List.of();
        list = mergeSort.sort(list);
        Assertions.assertEquals(List.of(), list);
    }

    @Test
    void oneItem() {
        List<Integer> list = List.of(1);
        list = mergeSort.sort(list);
        Assertions.assertEquals(List.of(1), list);
    }

    @Test
    void twoUnsortedItems() {
        List<Integer> list = Arrays.asList(2, 1);
        list = mergeSort.sort(list);
        Assertions.assertEquals(List.of(1, 2), list);
    }

    @Test
    void threeUnsortedItems() {
        List<Integer> list = Arrays.asList(2, 3, 1);
        list = mergeSort.sort(list);
        Assertions.assertEquals(List.of(1, 2, 3), list);
    }

    @Test
    void manyUnsortedItems() {
        final int limit = 1000;
        final long seed = 1L;
        final Random random = new Random(seed);

        List<Integer> actualList = IntStream.generate(random::nextInt)
                .limit(limit)
                .boxed()
                .collect(Collectors.toList());

        random.setSeed(seed);
        List<Integer> expectedList = IntStream.generate(random::nextInt)
                .limit(limit)
                .sorted()
                .boxed()
                .toList();

        actualList = mergeSort.sort(actualList);

        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void withComparator() {
        List<Integer> list = Arrays.asList(7, 2, 5, 10, 9, 1, 4, 7, 3, 8);
        list = mergeSort.sort(list, Comparator.reverseOrder());
        Assertions.assertEquals(List.of(10, 9, 8, 7, 7, 5, 4, 3, 2, 1), list);
    }

    @Test
    void withNullComparator() {
        List<Integer> list = Arrays.asList(7, 2, 5, 10, 9, 1, 4, 7, 3, 8);
        Assertions.assertThrows(IllegalArgumentException.class, () -> mergeSort.sort(list, null));
    }
}