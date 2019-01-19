package com.structurithms;

import java.util.Comparator;
import java.util.List;

public class InsertionSort {

    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        Object[] array = list.toArray();
        insertionSortOperation(array, comparator);
        for (int i = 0; i < array.length; i++) {
            list.set(i, (T) array[i]);
        }
    }

    public static <T> void sort(List<T> list) {
        Object[] array = list.toArray();
        insertionSortOperation(array);
        for (int i = 0; i < array.length; i++) {
            list.set(i, (T) array[i]);
        }
    }

    private static <T> void insertionSortOperation(Object[] arr, Comparator<T> comparator) {
        for (int i = 1; i < arr.length; ++i) {
            T key = (T) arr[i];
            int j = i - 1;
            while (j >= 0 && (comparator.compare((T) arr[j], key)) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    private static <T> void insertionSortOperation(Object[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            T key = (T) arr[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable) arr[j]).compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
