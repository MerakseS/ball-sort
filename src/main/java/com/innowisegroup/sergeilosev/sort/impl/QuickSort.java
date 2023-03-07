package com.innowisegroup.sergeilosev.sort.impl;

import com.innowisegroup.sergeilosev.sort.Sort;

import java.util.Comparator;
import java.util.List;

public class QuickSort implements Sort {

    @Override
    public <T extends Comparable<? super T>> List<T> sort(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Can't sort null");
        }

        quickSort(list, 0, list.size() - 1, Comparator.naturalOrder());

        return list;
    }

    @Override
    public <T> List<T> sort(List<T> list, Comparator<? super T> comparator) {
        if (list == null) {
            throw new IllegalArgumentException("Can't sort null");
        }

        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        }

        quickSort(list, 0, list.size() - 1, comparator);

        return list;
    }

    private <T> void quickSort(List<T> list, int from, int to, Comparator<? super T> comparator) {
        if (list.size() == 0) {
            return;
        }

        if (from >= to) {
            return;
        }

        int partitioningIndex = partition(list, from, to, comparator);
        quickSort(list, from, partitioningIndex - 1, comparator);
        quickSort(list, partitioningIndex, to, comparator);
    }

    private <T> int partition(List<T> list, int from, int to, Comparator<? super T> comparator) {
        int i = from;
        int j = to;
        T pivot = list.get(from);

        while (i <= j) {
            while (comparator.compare(list.get(i), pivot) < 0) {
                i++;
            }

            while (comparator.compare(list.get(j), pivot) > 0) {
                j--;
            }

            if (i <= j) {
                swap(list, i, j);
                i++;
                j--;
            }
        }

        return i;
    }
}
