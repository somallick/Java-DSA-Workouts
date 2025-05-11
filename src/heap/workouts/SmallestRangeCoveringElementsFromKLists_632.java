package src.heap.workouts;

import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists
public class SmallestRangeCoveringElementsFromKLists_632 {

    // Best Sol - TC- k*n log(k*n) SC - O(k)
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Info> minHeap = new PriorityQueue<>();
        int totalRows = nums.size();

        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;

        for (int i = 0; i < totalRows; i++) {
            int num = nums.get(i).get(0);
            minHeap.add(new Info(num, i, 0));
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        int startValue = minValue, endValue = maxValue; // final answer range value will be stored here

        while (!minHeap.isEmpty()) {
            Info front = minHeap.poll();
            minValue = front.value;

            if ((maxValue - minValue) < (endValue - startValue)) {
                endValue = maxValue;
                startValue = minValue;
            }
            int currTotalColumns = nums.get(front.rowIndex).size();
            if (front.colIndex < currTotalColumns - 1) {
                int element = nums.get(front.rowIndex).get(front.colIndex + 1);
                minHeap.add(new Info(element, front.rowIndex, front.colIndex + 1));
                maxValue = Math.max(maxValue, element);
            } else
                break;
        }
        return (new int[]{startValue, endValue});
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
}
