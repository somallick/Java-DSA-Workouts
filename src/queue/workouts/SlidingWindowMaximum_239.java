package src.queue.workouts;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/sliding-window-maximum
public class SlidingWindowMaximum_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        int outputIndex = 0;
        Deque<Integer> indexDeque = new LinkedList<>();

        // Step 1 - Process the first window
        for (int i = 0; i < k; i++) {

            // Step 1.1 - store each element index in queue and
            // also pop those elements which are smaller than the current element
            // from the left of the queue  and then add i.e. compare and pop from back of the queue
            int element = nums[i];
            while (!indexDeque.isEmpty() && nums[indexDeque.peekLast()] < element)
                indexDeque.pollLast();
            indexDeque.add(i);
        }

        // Step 1.2 - store the first negative element in output list
        output[outputIndex++] = nums[indexDeque.peek()];

        // Step 2 - Process the remaining window
        for (int i = k; i < nums.length; i++) {

            // Step 2.1 - removal of index of element from queue which doesn't belong to present window
            if (!indexDeque.isEmpty() && (i - indexDeque.peek() >= k))
                indexDeque.poll();

            // Step 2.2 - addition of index new element in queue which belong to present window
            // also pop those elements which are smaller than the new element
            // from the left of the queue then add i.e. compare and pop from back of the queue
            int element = nums[i];
            while (!indexDeque.isEmpty() && nums[indexDeque.peekLast()] < element) {
                indexDeque.pollLast();
            }
            indexDeque.add(i);

            // Step 2.3 - store the max element in output list from the present window
            output[outputIndex++] = nums[indexDeque.peek()];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 4};
        maxSlidingWindow(nums, 2);
    }
}
