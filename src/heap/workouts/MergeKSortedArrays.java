package src.heap.workouts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
public class MergeKSortedArrays {

    // Best Sol - TC- k*k log(k*k) SC - O(k)
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> finalSortedArray = new ArrayList<>();
        PriorityQueue<Info> minHeap = new PriorityQueue<>();
        int totalRows = K;
        int totalColumns = K;
        for (int i = 0; i < totalRows; i++) {
            Info num = new Info(arr[i][0], i, 0);
            minHeap.add(num);
        }
        while (!minHeap.isEmpty()) {
            Info front = minHeap.poll();
            finalSortedArray.add(front.value);

            if (front.colIndex < totalColumns - 1) {
                Info num = new Info(arr[front.rowIndex][front.colIndex + 1], front.rowIndex, front.colIndex + 1);
                minHeap.add(num);
            }
        }
        return finalSortedArray;
    }

    private static class Info implements Comparable<Info> {
        int value;
        int rowIndex;
        int colIndex;

        public Info(int value, int rowIndex, int colIndex) {
            this.value = value;
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

        @Override
        public int compareTo(Info o) {
            if (this.value <= o.value) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    //TC- k*k log(k*k) SC- O(k*k) - Easy Sol but space complexity is more
    public static ArrayList<Integer> mergeKArrays_sol2(int[][] arr, int K) {
        // Write your code here.
        ArrayList<Integer> finalSortedArray = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                minHeap.add(arr[i][j]);
            }
        }
        while (!minHeap.isEmpty()) {
            finalSortedArray.add(minHeap.poll());
        }
        return finalSortedArray;
    }
}
