package src.heap.workouts;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueuePractise {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(30);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(50);

        // stored in min heap by default
        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.peek());

        // stored by max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(50);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.peek());

    }
}
