package com.innowisegroup.sergeilosev.sort.impl;

import com.innowisegroup.sergeilosev.sort.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements Sort {

    @Override
    public <T extends Comparable<? super T>> List<T> sort(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Can't sort null object.");
        }

        return mergeSort(list);
    }

    private <T extends Comparable<? super T>> List<T> mergeSort(List<T> list) {
        if (list.size() <= 1) {
            return list;
        }

        List<T> left = list.subList(0, list.size() / 2);
        List<T> right = list.subList(left.size(), list.size());

        return merge(mergeSort(left), mergeSort(right));
    }

    private <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>(left.size() + right.size());
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }

    @Override
    public <T> List<T> sort(List<T> list, Comparator<? super T> comparator) {
        if (list == null) {
            throw new IllegalArgumentException("Can't sort null object.");
        }

        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        }

        return mergeSort(list, comparator);
    }

    private <T> List<T> mergeSort(List<T> list, Comparator<? super T> comparator) {
        if (list.size() <= 1) {
            return list;
        }

        List<T> left = list.subList(0, list.size() / 2);
        List<T> right = list.subList(left.size(), list.size());

        return merge(mergeSort(left, comparator), mergeSort(right, comparator), comparator);
    }

    private <T> List<T> merge(List<T> left, List<T> right, Comparator<? super T> comparator) {
        List<T> result = new ArrayList<>(left.size() + right.size());
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }
}
