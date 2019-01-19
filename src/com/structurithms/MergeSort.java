package com.structurithms;

import java.util.Comparator;
import java.util.List;

public class MergeSort {

    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        Object[] array = list.toArray();
        mergeSortOperation(array, 0, array.length - 1, comparator);
        for (int i = 0; i < array.length; i++) {
            list.set(i, (T) array[i]);
        }
    }

    public static <T> void sort(List<T> list) {
        Object[] array = list.toArray();
        mergeSortOperation(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            list.set(i, (T) array[i]);
        }
    }

    private static <T> void mergeSortOperation(Object[] arr, int first, int last, Comparator<T> comparator) {
        if (first < last) {
            int mid = (first + last) >>> 1;
            mergeSortOperation(arr, first, mid, comparator);
            mergeSortOperation(arr, mid + 1, last, comparator);
            int s1 = mid - first + 1;
            int s2 = last - mid;
            Object[] leftArray = new Object[s1];
            Object[] rightArray = new Object[s2];
            System.arraycopy(arr, first, leftArray, 0, s1);
            System.arraycopy(arr, mid + 1, rightArray, 0, s2);
            int i, j, k;
            for (i = 0, j = 0, k = first; i < s1 && j < s2; k++) {
                if (comparator.compare((T) leftArray[i], (T) rightArray[j]) <= 0) {
                    arr[k] = leftArray[i++];
                } else {
                    arr[k] = rightArray[j++];
                }
            }
            if (i < s1) {
                System.arraycopy(leftArray, i, arr, k, s1 - i);
            }
            if (j < s2) {
                System.arraycopy(rightArray, j, arr, k, s2 - j);
            }
        }
    }

    private static void mergeSortOperation(Object[] arr, int first, int last) {
        if (first < last) {
            int mid = (first + last) >>> 1;
            mergeSortOperation(arr, first, mid);
            mergeSortOperation(arr, mid + 1, last);
            int s1 = mid - first + 1;
            int s2 = last - mid;
            Object[] leftArray = new Object[s1];
            Object[] rightArray = new Object[s2];
            System.arraycopy(arr, first, leftArray, 0, s1);
            System.arraycopy(arr, mid + 1, rightArray, 0, s2);
            int i, j, k;
            for (i = 0, j = 0, k = first; i < s1 && j < s2; k++) {
                if (((Comparable) leftArray[i]).compareTo(rightArray[j]) <= 0) {
                    arr[k] = leftArray[i++];
                } else {
                    arr[k] = rightArray[j++];
                }
            }
            if (i < s1) {
                System.arraycopy(leftArray, i, arr, k, s1 - i);
            }
            if (j < s2) {
                System.arraycopy(rightArray, j, arr, k, s2 - j);
            }
        }
    }

}
