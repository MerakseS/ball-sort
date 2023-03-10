package com.innowisegroup.sergeilosev.service;

import com.innowisegroup.sergeilosev.sort.Sort;

import java.util.Comparator;
import java.util.List;

public interface SortService {

    <T extends Comparable<? super T>> List<T> sort(List<T> list, Sort sort);

    <T> List<T> sort(List<T> list, Sort sort, Comparator<? super T> comparator);
}
