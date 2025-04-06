package src.queue.workouts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/interleave-the-first-half-of-the-queue-with-second-half/1
public class InterleaveFirstHalfQueueWithSecondHalf {
    public static Queue<Integer> rearrangeQueue(Queue<Integer> q) {
        // code here
        Queue<Integer> q2 = new LinkedList<>();
        int n = q.size();
        int halfSize = n / 2;
        while (halfSize > 0) {
            q2.add(q.poll());
            halfSize--;
        }
        int size = q2.size();
        while (size > 0) {
            q.add(q2.poll());
            q.add(q.poll());
            size--;
        }
        // test case issue - in question its told even queue
        // so for odd count remove the last data which is present in front of result queue
        if (n % 2 == 1)
            q.poll();
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(2, 4, 3, 1));
        rearrangeQueue(queue);
        System.out.println(queue);
    }
}
