package src.queue.workouts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegativeInEveryWindowOfSizeK {
    public static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        Queue<Integer> indexQueue = new LinkedList<>();
        List<Integer> output = new ArrayList<>();
        // Step 1 - Process the first window
        for (int i = 0; i < k; i++) {
            // Step 1.1 - store all negative element index in queue
            if (arr[i] < 0)
                indexQueue.add(i);
        }
        // Step 1.2 - store the first negative element in output list if queue is not empty else zero
        if (indexQueue.isEmpty())
            output.add(0);
        else {
            int index = indexQueue.peek();
            output.add(arr[index]);
        }
        // Step 2 - Process the remaining window
        for (int i = k; i < arr.length; i++) {

            // Step 2.1 - removal of index of element from queue which doesn't belong to present window
            if (!indexQueue.isEmpty() && (i - indexQueue.peek() >= k))
                indexQueue.poll();

            // Step 2.2 - addition of index new negative element in queue which belong to present window
            if (arr[i] < 0)
                indexQueue.add(i);

            // Step 2.3 - store the first negative element in output list from the present window if queue is not empty else zero
            if (indexQueue.isEmpty())
                output.add(0);
            else {
                int index = indexQueue.peek();
                output.add(arr[index]);
            }
        }
        return output;
    }
}
