package org.saderfamily;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] unSortedInts = {4, 10, 3, 5, 1, 17, 2, 48, 37, 15};
        for (int i: unSortedInts) {
            System.out.println(i);
        }
        System.out.println("Blank for your protection");

        new MergeSort().mergeSort(unSortedInts);
        for (int i: unSortedInts) {
            System.out.println(i);
        }

    }

    private int[] mergeSort(int[] unSortedInts) {
        int[] mergeCopy = Arrays.copyOf(unSortedInts, unSortedInts.length);
        topDownSplitMerge(mergeCopy, 0, unSortedInts.length, unSortedInts);
        return unSortedInts;
    }

    private void topDownSplitMerge(int[] mergeCopy, int startIndex, int endIndex, int[] unSortedInts) {
        if(endIndex - startIndex < 2) {
            return;
        }

        int middle = (endIndex + startIndex)/2;
        topDownSplitMerge(unSortedInts, startIndex, middle, mergeCopy);
        topDownSplitMerge(unSortedInts, middle, endIndex, mergeCopy);
        topDownMerge(mergeCopy, startIndex, middle, endIndex, unSortedInts);
    }

    private void topDownMerge(int[] mergeCopy, int startIndex, int middle, int endIndex, int[] unSortedInts) {
        int i = startIndex;
        int j = middle;

        for(int k = startIndex; k < endIndex; k++) {
            if(i < middle && (j >= endIndex || mergeCopy[i] < mergeCopy[j])) {
                unSortedInts[k] = mergeCopy[i];
                i = i + 1;
            } else {
                unSortedInts[k] = mergeCopy[j];
                j = j + 1;
            }
        }
    }
}
