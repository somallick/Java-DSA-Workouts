package src.heap.workouts;

import java.util.Arrays;

public class Heap {
    int[] arr;
    int capacity;
    int index;

    public Heap(int capacity) {
        this.capacity = capacity;
        arr = new int[this.capacity];
        index = -1;
        // as heap is a 0 index array so increment the index by zero and insert the data
    }

    public void printHeap() {
        for (int i = 0; i <= index; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //TC - O(log n) SC - O(1)
    public void insert(int val) {
        if (index == this.capacity) {
            System.out.println("overflow");
            return;
        }
        //store it in array
        index++;
        arr[index] = val;

        //Max-heapify Up
        int currIndex = index;
        while (currIndex > 0) {
            int parentIndex = (currIndex - 1) / 2;
            if (arr[parentIndex] < arr[currIndex]) {
                swap(parentIndex, currIndex);
                currIndex = parentIndex;
            } else
                break;
        }
    }

    //TC - O(log n) SC - O(1)
    public void deleteRootFromHeap() {
        if (index < 0) {
            System.out.println("underflow");
            return;
        }
        //replace root value with right most value in the lowest level
        arr[0] = arr[index];
        //Remove the last element from the heap.
        index--;

        // assume root is the largest value as max heapify
        int rootIndex = 0;
        int largestIndex = rootIndex;
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;

        //Down-Heapify (Bubble-Down): Compare the new root with its children.
        // If the heap property is violated, swap it with the larger (in max-heap) or smaller (in min-heap) child.
        // Repeat until the heap property is restored.
        while (leftIndex <= index || rightIndex <= index) {
            if (leftIndex <= index && arr[largestIndex] < arr[leftIndex])
                largestIndex = leftIndex;
            if (rightIndex <= index && arr[largestIndex] < arr[rightIndex])
                largestIndex = rightIndex;

            if (largestIndex == rootIndex) // root is in suitable position no further heapify required
                break;

            swap(rootIndex, largestIndex);

            rootIndex = largestIndex;
            leftIndex = 2 * rootIndex + 1;
            rightIndex = 2 * rootIndex + 2;
        }

    }
    private void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void maxHeapifyDown(int rootIndex) {
        int largestIndex = rootIndex;
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;

        while (leftIndex <= index || rightIndex <= index) {
            if (leftIndex <= index && arr[largestIndex] < arr[leftIndex])
                largestIndex = leftIndex;
            if (rightIndex <= index && arr[largestIndex] < arr[rightIndex])
                largestIndex = rightIndex;

            if (largestIndex == rootIndex) // root is in suitable position no further heapify required
                break;

            swap(rootIndex, largestIndex);

            rootIndex = largestIndex;
            leftIndex = 2 * rootIndex + 1;
            rightIndex = 2 * rootIndex + 2;
        }
    }
    private void maxHeapifyUp(int rootIndex) {
        int currIndex = rootIndex;
        while (currIndex > 0) {
            int parentIndex = (currIndex - 1) / 2;
            if (arr[parentIndex] < arr[currIndex]) {
                swap(parentIndex, currIndex);
                currIndex = parentIndex;
            } else
                break;
        }
    }

    public void deleteElementByPosition(int position) {
        if (position < 0 || position > index) {
            System.out.println("Wrong Position");
            return;
        }
        int currIndex = position;

        swap(currIndex, index);
        index--;

        maxHeapifyDown(currIndex);
        maxHeapifyUp(currIndex);



    }


    public static void main(String[] args) {
        Heap heap = new Heap(7);
        heap.insert(40);
        heap.insert(30);
        heap.insert(25);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(50);
        heap.printHeap();
//        heap.deleteRootFromHeap();
//        heap.printHeap();
//        heap.deleteRootFromHeap();
//        heap.printHeap();
//        heap.deleteElementByPosition(5);
//        heap.printHeap();
    }
}
