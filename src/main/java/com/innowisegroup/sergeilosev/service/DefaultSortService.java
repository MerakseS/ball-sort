package com.innowisegroup.sergeilosev.service;

import com.innowisegroup.sergeilosev.sort.Sort;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;

@Slf4j
public class DefaultSortService implements SortService {

    @Override
    public <T extends Comparable<? super T>> List<T> sort(List<T> list, Sort sort) {
        if (list == null) {
            throw new IllegalArgumentException("Can't sort null");
        }

        if (sort == null) {
            throw new IllegalArgumentException("Sorter cannot be null");
        }

        log.info("Sorting by {}", sort.getClass().getSimpleName());
        log.info("List to sort: {}", list);

        list = sort.sort(list);

        log.info("Sorted list:  {}", list);

        return list;
    }

    @Override
    public <T> List<T> sort(List<T> list, Sort sort, Comparator<? super T> comparator) {
        if (list == null) {
            throw new IllegalArgumentException("Can't sort null");
        }

        if (sort == null) {
            throw new IllegalArgumentException("Sorter cannot be null");
        }

        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        }

        log.info("Sorting by {} with comparator {}.",
                sort.getClass().getSimpleName(),
                comparator.getClass().getSimpleName());

        log.info("List to sort: {}", list);

        list = sort.sort(list, comparator);

        log.info("Sorted list:  {}", list);

        return list;
    }
}
