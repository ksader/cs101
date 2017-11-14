package org.saderfamily;

public class HeapSort {
    public static void main(String args[]) {
        int[] unSortedInts = {4, 10, 3, 5, 1};
        new HeapSort().heapsort(unSortedInts);

        for (int i : unSortedInts) {
            System.out.println(i);
        }


    }

    void heapsort(int[] numbers) {
        heapify(numbers, numbers.length);

        int end = numbers.length - 1;

        while(end > 0) {
            swap(numbers, end, 0);
            end--;
            siftDown(numbers, 0, end);
        }
    }

    void siftDown(int[] numbers, int start, int end) {
        int rootIndex = start;

        while(leftChild(rootIndex) <= end) {
            int child = leftChild(rootIndex);
            int swapIndex = rootIndex;

            if(numbers[swapIndex] < numbers[child]) {
                swapIndex = child;
            }

            if(rightChild(rootIndex) <= end && numbers[swapIndex] < numbers[rightChild(rootIndex)]) {
                swapIndex = rightChild(rootIndex);
            }

            if(swapIndex == rootIndex)  {
                return;
            } else {
                swap(numbers, rootIndex, swapIndex);
                rootIndex = swapIndex;
            }
        }
    }

    private int leftChild(int root) {
        return 2 * root + 1;
    }

    private int rightChild(int root) {
        return 2 * root + 2;
    }

    void swap(int[] numbers, int end, int start) {
        int heapRoot = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = heapRoot;
    }


    void heapify(int[] numbers, int length) {
        int start = length - 1;

        while(start >= 0) {
            siftDown(numbers, start, length - 1);
            start = start - 1;
        }
    }


}
