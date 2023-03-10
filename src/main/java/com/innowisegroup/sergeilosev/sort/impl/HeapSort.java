package com.innowisegroup.sergeilosev.sort.impl;

import com.innowisegroup.sergeilosev.sort.Sort;

import java.util.Comparator;
import java.util.List;

public class HeapSort implements Sort {

    private int heapSize;

    @Override
    public <T> List<T> sort(List<T> list, Comparator<? super T> comparator) {
        if (list == null) {
            throw new IllegalArgumentException("Can't sort null");
        }

        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        }

        heapSort(list, comparator);

        return list;
    }

    private <T> void heapSort(List<T> list, Comparator<? super T> comparator) {
        buildHeap(list, comparator);
        while (heapSize > 1) {
            swap(list, 0, heapSize - 1);
            heapSize--;
            heapify(list, 0, comparator);
        }
    }

    private <T> void buildHeap(List<T> list, Comparator<? super T> comparator) {
        heapSize = list.size();
        for (int i = list.size() / 2; i >= 0; i--) {
            heapify(list, i, comparator);
        }
    }

    private <T> void heapify(List<T> list, int i, Comparator<? super T> comparator) {
        int largestIndex = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex < heapSize && comparator.compare(list.get(leftIndex), list.get(largestIndex)) > 0) {
            largestIndex = leftIndex;
        }
        if (rightIndex < heapSize && comparator.compare(list.get(rightIndex), list.get(largestIndex)) > 0) {
            largestIndex = rightIndex;
        }

        if (i != largestIndex) {
            swap(list, i, largestIndex);
            heapify(list, largestIndex, comparator);
        }
    }
}
