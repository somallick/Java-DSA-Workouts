package src.queue.workouts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://www.naukri.com/code360/problems/reverse-first-k-elements-of-queue_982771
public class ReverseFirstKElementsOfQueue {
    public static Queue<Integer> reverseElements(Queue<Integer> queue, int k) {
        int n = queue.size();
        if (n < k)
            return queue;
        return reverseElements(queue, queue.size(), k);
    }

    public static Queue<Integer> reverseElements(Queue<Integer> queue, int size, int k) {
        if (size < k) {
            // remaining element pushing in the same sequence(non-reverse) in the queue)
            while (size > 0) {
                queue.add(queue.poll());
                size--;
            }
            return queue;
        }
        // reverse k elements from queue and add those elements in queue (Enqueue)
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty())
            queue.add(stack.pop());

        // Process for first k elements is done and now process next k elements of all sets using recursion
        size = size - k;
        return reverseElements(queue, size, k);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110));
        queue = reverseElements(queue, 3);
        for (Integer q : queue) {
            System.out.print(q + " ");
        }
        System.out.println();
    }
}
