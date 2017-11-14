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
        int root = start;

        while(leftChild(root) <= end) {
            int child = leftChild(root);
            int swap = root;

            if(numbers[swap] < numbers[child]) {
                swap = child;
            }

            int rightChild = child + 1;
            if(rightChild <= end && numbers[swap] < numbers[rightChild]) {
                swap = rightChild;
            }

            if(swap == root)  {
                return;
            } else {
                swap(numbers, root, swap);
                root = swap;
            }
        }
    }

    private int leftChild(int root) {
        return 2 * root + 1;
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
