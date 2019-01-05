package com.structurithms;

import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    public static <T> int search(List<T> list, T element) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int compare = ((Comparable)list.get(mid)).compareTo(element);
            if (compare > 0){
                high = mid-1;
            } else if (compare < 0){
                low = mid +1;
            } else{
                return mid;
            }
        }
        return -1;
    }

}
