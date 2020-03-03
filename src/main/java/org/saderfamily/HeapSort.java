package org.saderfamily;

public class HeapSort {
    public static void main(String args[]) {
        int[] unSortedInts = {4, 10, 3, 5, 1};
        new HeapSort().heapsort(unSortedInts);

        for (int i : unSortedInts) {
            System.out.println(i);
        }

        unSortedInts =  new int[]{4, 10, 3, 5, 1};
        new HeapSort().heapsortUp(unSortedInts);
        for (int i : unSortedInts) {
            System.out.println(i);
        }

    }

    private int[] heapsortUp(int[] numbers) {
        heapifyUp(numbers, numbers.length);

        int end = numbers.length - 1;

        while(end > 0) {
            swap(numbers, end, 0);
            end--;
            siftDown(numbers, 0, end);
        }

        return numbers;
    }

    public int[] heapsort(int[] numbers) {
        heapify(numbers, numbers.length);

        int end = numbers.length - 1;

        while(end > 0) {
            swap(numbers, end, 0);
            end--;
            siftDown(numbers, 0, end);
        }

        return numbers;
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

    /**
     * Another way to build the heap
     * @return
     */
    void siftUp(int[] numbers, int start, int end) {
        int child = end;
        while(child > start) {
          int parent = parentOf(child);
          if(numbers[parent] < numbers[child]) {
              swap(numbers, parent, child);
              child = parent;
          } else {
              return;
          }
        }
    }

    void heapifyUp(int[] numbers, int count) {
        int end = 1;
        while(end < count) {
            siftUp(numbers, 0, end);
            end = end + 1;
        }
    }

    int parentOf(int child) {
        return (int) Math.floor((child - 1 ) / 2);
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
        int start = parentOf(length - 1);

        while(start >= 0) {
            siftDown(numbers, start, length - 1);
            start = start - 1;
        }
    }


}
