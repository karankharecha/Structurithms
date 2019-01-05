package com.structurithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VintageSorts {

    public static <T> void mergeSort(List<T> list, Comparator<T> comparator){
        Object[] array = list.toArray();
        mergeSortOperation(array,0, array.length-1, comparator);
        for (int i=0;i<array.length;i++){
            list.set(i, (T)array[i]);
        }
    }

    public static <T> void mergeSort(List<T> list){
        Object[] array = list.toArray();
        mergeSortOperation(array,0, array.length-1);
        for (int i=0;i<array.length;i++){
            list.set(i, (T)array[i]);
        }
    }

    public static <T> void quickSort(List<T> list, Comparator<T> comparator) {
        Object[] array = list.toArray();
        quickSortOperation(array, 0, array.length-1, comparator);
        for (int i=0;i<array.length;i++){
            list.set(i, (T)array[i]);
        }
    }

    public static <T> void quickSort(List<T> list) {
        Object[] array = list.toArray();
        quickSortOperation(array, 0, array.length-1);
        for (int i=0;i<array.length;i++){
            list.set(i, (T)array[i]);
        }
    }

    public static <T> void heapSort(List<T> list, Comparator<T> comparator) {
        Object[] array = list.toArray();
        int n = array.length;
        for(int i=(n/2)-1 ; i>=0 ; i--){
            heapify(array,i,n, comparator);
        }
        for(int i=(n-1) ; i>=0 ; i--){
            Object temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array,0,i, comparator);
        }
        for (int i=0;i<array.length;i++){
            list.set(i, (T)array[i]);
        }
    }

    public static <T> void heapSort(List<T> list) {
        Object[] array = list.toArray();
        int n = array.length;
        for(int i=(n/2)-1 ; i>=0 ; i--){
            heapify(array,i,n);
        }
        for(int i=(n-1) ; i>=0 ; i--){
            Object temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array,0,i);
        }
        for (int i=0;i<array.length;i++){
            list.set(i, (T)array[i]);
        }
    }

    private static <T> void quickSortOperation(Object[] arr, int first, int last, Comparator<T> comparator){
        if(first < last){
            Object pivot = arr[last];
            int i = (first - 1);
            for (int j=first;j<last;j++){
                if(comparator.compare((T)arr[j], (T)pivot) <= 0){
                    Object temp = arr[++i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            Object temp = arr[++i];
            arr[i] = arr[last];
            arr[last] = temp;

            quickSortOperation(arr, first, i-1, comparator);
            quickSortOperation(arr, i+1, last, comparator);
        }
    }

    private static void quickSortOperation(Object[] arr, int first, int last){
        if(first < last){
            Object pivot = arr[last];
            int i = (first - 1);
            for (int j=first;j<last;j++){
                if(((Comparable)arr[j]).compareTo(pivot) <= 0){
                    Object temp = arr[++i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            Object temp = arr[++i];
            arr[i] = arr[last];
            arr[last] = temp;

            quickSortOperation(arr, first, i-1);
            quickSortOperation(arr, i+1, last);
        }
    }

    private static <T> void mergeSortOperation(Object[] arr, int first, int last, Comparator<T> comparator){
        if(first < last){
            int mid = (first + last) >>> 1;
            mergeSortOperation(arr, first, mid, comparator);
            mergeSortOperation(arr, mid + 1, last, comparator);
            int s1 = mid - first + 1;
            int s2 = last - mid;
            Object[] leftArray = new Object[s1];
            Object[] rightArray = new Object[s2];
            System.arraycopy(arr, first, leftArray, 0, s1);
            System.arraycopy(arr,mid+1, rightArray, 0, s2);
            int i,j,k;
            for(i=0, j=0, k=first; i<s1 && j<s2; k++){
                if (comparator.compare((T)leftArray[i], (T)rightArray[j]) <= 0){
                    arr[k] = leftArray[i++];
                } else {
                    arr[k] = rightArray[j++];
                }
            }
            if (i < s1){
                System.arraycopy(leftArray, i, arr, k, s1-i);
            }
            if (j < s2){
                System.arraycopy(rightArray, j, arr, k, s2-j);
            }
        }
    }

    private static void mergeSortOperation(Object[] arr, int first, int last){
        if(first < last){
            int mid = (first + last) >>> 1;
            mergeSortOperation(arr, first, mid);
            mergeSortOperation(arr, mid + 1, last);
            int s1 = mid - first + 1;
            int s2 = last - mid;
            Object[] leftArray = new Object[s1];
            Object[] rightArray = new Object[s2];
            System.arraycopy(arr, first, leftArray, 0, s1);
            System.arraycopy(arr,mid+1, rightArray, 0, s2);
            int i,j,k;
            for(i=0, j=0, k=first; i<s1 && j<s2; k++){
                if (((Comparable)leftArray[i]).compareTo(rightArray[j]) <= 0){
                    arr[k] = leftArray[i++];
                } else {
                    arr[k] = rightArray[j++];
                }
            }
            if (i < s1){
                System.arraycopy(leftArray, i, arr, k, s1-i);
            }
            if (j < s2){
                System.arraycopy(rightArray, j, arr, k, s2-j);
            }
        }
    }

    private static <T> void heapify(Object[] arr, int first, int last, Comparator<T> comparator){
        int index = first;
        int leftIndex = (index*2) + 1;
        int rightIndex = (index*2) + 2;
        if(leftIndex < last && comparator.compare((T)arr[leftIndex], (T)arr[index]) > 0){
            index = leftIndex;
        }
        if(rightIndex < last && comparator.compare((T)arr[rightIndex], (T)arr[index]) > 0){
            index = rightIndex;
        }
        if( index != first ){
            Object temp = arr[index];
            arr[index] = arr[first];
            arr[first] = temp;
            heapify(arr,index,last, comparator);
        }
    }

    private static void heapify(Object[] arr, int first, int last){
        int index = first;
        int leftIndex = (index*2) + 1;
        int rightIndex = (index*2) + 2;
        if(leftIndex < last && ((Comparable)arr[leftIndex]).compareTo(arr[index]) > 0){
            index = leftIndex;
        }
        if(rightIndex < last && ((Comparable)arr[rightIndex]).compareTo(arr[index]) > 0){
            index = rightIndex;
        }
        if( index != first){
            Object temp = arr[index];
            arr[index] = arr[first];
            arr[first] = temp;
            heapify(arr,index,last);
        }
    }

}