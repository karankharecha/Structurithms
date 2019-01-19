package com.structurithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort {

    public static void sort(List<Integer> list) {
        ArrayList<Integer> sortedList = new ArrayList<>(Collections.nCopies(list.size(), 0));
        ArrayList<Integer> tempList = new ArrayList<>(Collections.nCopies(Collections.max(list) + 1, 0));
        int maxValue = Collections.max(list);

        for (Integer aList : list) {
            tempList.set(aList, tempList.get(aList) + 1);
        }
        for (int i = 1; i <= maxValue; i++) {
            tempList.set(i, tempList.get(i) + tempList.get(i - 1));
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sortedList.set(tempList.get(list.get(i)) - 1, list.get(i));
            tempList.set(list.get(i), tempList.get(list.get(i)) - 1);
        }
        list.clear();
        list.addAll(sortedList);
    }

}
