package src.heap.workouts;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array
public class KthLargestElementInAnArray_215 {

    //TC O(n log k) SC O(k) k<=n - Best Sol
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            minHeap.add(nums[i]);

        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

    //TC O(n log n) SC O(n)
    public int findKthLargest_sol2(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums)
            maxHeap.add(num);

        for (int i = 1; i < k; i++)
            maxHeap.poll();
        return maxHeap.peek();
    }
}
