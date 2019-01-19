package com.structurithms;

import java.util.Comparator;
import java.util.List;

public class HeapSort {

    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        Object[] array = list.toArray();
        int n = array.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(array, i, n, comparator);
        }
        for (int i = (n - 1); i >= 0; i--) {
            Object temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, 0, i, comparator);
        }
        for (int i = 0; i < array.length; i++) {
            list.set(i, (T) array[i]);
        }
    }

    public static <T> void sort(List<T> list) {
        Object[] array = list.toArray();
        int n = array.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(array, i, n);
        }
        for (int i = (n - 1); i >= 0; i--) {
            Object temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, 0, i);
        }
        for (int i = 0; i < array.length; i++) {
            list.set(i, (T) array[i]);
        }
    }

    private static <T> void heapify(Object[] arr, int first, int last, Comparator<T> comparator) {
        int index = first;
        int leftIndex = (index * 2) + 1;
        int rightIndex = (index * 2) + 2;
        if (leftIndex < last && comparator.compare((T) arr[leftIndex], (T) arr[index]) > 0) {
            index = leftIndex;
        }
        if (rightIndex < last && comparator.compare((T) arr[rightIndex], (T) arr[index]) > 0) {
            index = rightIndex;
        }
        if (index != first) {
            Object temp = arr[index];
            arr[index] = arr[first];
            arr[first] = temp;
            heapify(arr, index, last, comparator);
        }
    }

    private static void heapify(Object[] arr, int first, int last) {
        int index = first;
        int leftIndex = (index * 2) + 1;
        int rightIndex = (index * 2) + 2;
        if (leftIndex < last && ((Comparable) arr[leftIndex]).compareTo(arr[index]) > 0) {
            index = leftIndex;
        }
        if (rightIndex < last && ((Comparable) arr[rightIndex]).compareTo(arr[index]) > 0) {
            index = rightIndex;
        }
        if (index != first) {
            Object temp = arr[index];
            arr[index] = arr[first];
            arr[first] = temp;
            heapify(arr, index, last);
        }
    }
}
