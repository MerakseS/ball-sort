package com.innowisegroup.sergeilosev.sort;

import java.util.Comparator;
import java.util.List;

public interface Sort {

    <T extends Comparable<? super T>> void sort(List<T> list);

    <T> void sort(List<T> list, Comparator<? super T> comparator);
}
