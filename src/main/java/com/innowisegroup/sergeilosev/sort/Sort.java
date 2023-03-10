package com.innowisegroup.sergeilosev.sort;

import java.util.Comparator;
import java.util.List;

public interface Sort {

    default <T extends Comparable<? super T>> List<T> sort(List<T> list) {
        return sort(list, Comparator.naturalOrder());
    }

    <T> List<T> sort(List<T> list, Comparator<? super T> comparator);

    default <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
