package com.structurithms;

import java.util.ArrayList;
import java.util.Collections;

public class Heap<T> {

    private ArrayList<T> heap = new ArrayList<>();

    public void add(T element){
        heap.add(element);
        heapify(heap, 0, heap.size());
    }

    private static void heapify(ArrayList heapList, int first, int last) {
        int index = first;
        int leftIndex = (index * 2) + 1;
        int rightIndex = (index * 2) + 2;
        if (leftIndex < last && ((Comparable) heapList.get(leftIndex)).compareTo(heapList.get(index)) > 0) {
            index = leftIndex;
        }
        if (rightIndex < last && ((Comparable) heapList.get(rightIndex)).compareTo(heapList.get(index)) > 0) {
            index = rightIndex;
        }
        if (index != first) {
            Collections.swap(heapList, index, first);
            heapify(heapList, index, last);
        }
    }
}
