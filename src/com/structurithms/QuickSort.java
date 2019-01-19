package com.structurithms;

import java.util.Comparator;
import java.util.List;

public class QuickSort {

    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        Object[] array = list.toArray();
        quickSortOperation(array, 0, array.length - 1, comparator);
        for (int i = 0; i < array.length; i++) {
            list.set(i, (T) array[i]);
        }
    }

    public static <T> void sort(List<T> list) {
        Object[] array = list.toArray();
        quickSortOperation(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            list.set(i, (T) array[i]);
        }
    }

    private static <T> void quickSortOperation(Object[] arr, int first, int last, Comparator<T> comparator) {
        if (first < last) {
            Object pivot = arr[last];
            int i = (first - 1);
            for (int j = first; j < last; j++) {
                if (comparator.compare((T) arr[j], (T) pivot) <= 0) {
                    Object temp = arr[++i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            Object temp = arr[++i];
            arr[i] = arr[last];
            arr[last] = temp;

            quickSortOperation(arr, first, i - 1, comparator);
            quickSortOperation(arr, i + 1, last, comparator);
        }
    }

    private static void quickSortOperation(Object[] arr, int first, int last) {
        if (first < last) {
            Object pivot = arr[last];
            int i = (first - 1);
            for (int j = first; j < last; j++) {
                if (((Comparable) arr[j]).compareTo(pivot) <= 0) {
                    Object temp = arr[++i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            Object temp = arr[++i];
            arr[i] = arr[last];
            arr[last] = temp;

            quickSortOperation(arr, first, i - 1);
            quickSortOperation(arr, i + 1, last);
        }
    }
}
