package src.heap.assigments;

import java.util.Collections;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
public class KthSmallest {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++)
            maxHeap.add(arr[i]);

        for (int i = k; i < arr.length; i++) {
            if (maxHeap.peek() > arr[i]) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();

    }
}
