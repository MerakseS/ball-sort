package com.innowisegroup.sergeilosev.sort.impl;

import com.innowisegroup.sergeilosev.sort.Sort;

import java.util.Comparator;
import java.util.List;

public class QuickSort implements Sort {

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        if (list == null) {
            return;
        }

        quickSort(list, 0, list.size() - 1);
    }

    @Override
    public <T> void sort(List<T> list, Comparator<? super T> comparator) {
        if (list == null) {
            return;
        }

        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        }

        quickSort(list, 0, list.size() - 1, comparator);
    }

    private <T extends Comparable<? super T>> void quickSort(List<T> list, int from, int to) {
        if (list.size() == 0) {
            return;
        }

        if (from >= to) {
            return;
        }

        int partitioningIndex = partition(list, from, to);
        quickSort(list, from, partitioningIndex - 1);
        quickSort(list, partitioningIndex, to);
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

    private <T extends Comparable<? super T>> int partition(List<T> list, int from, int to) {
        int i = from;
        int j = to;
        T pivot = list.get(from);

        while (i <= j) {
            while (list.get(i).compareTo(pivot) < 0) {
                i++;
            }

            while (list.get(j).compareTo(pivot) > 0) {
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

    private <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
