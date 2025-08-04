package src.heap.workouts;

import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
public class MinimumCostOfRopes {
    public static int minCost(int[] arr) { // TC - O(n log n) SC - O(n)
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int a : arr) // O(n)
            minHeap.add(a);

        int totalCost = 0;

        while (minHeap.size() > 1) { //O(n log n)
            int cost = minHeap.poll() + minHeap.poll();
            totalCost += cost;
            minHeap.add(cost);
        }
        return totalCost;

    }
}
