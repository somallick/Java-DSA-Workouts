package src.heap.workouts;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream
public class FindMedianFromDataStream_295 {
    public static void main(String[] args) {
        int num = 1;
        MedianFinder obj = new MedianFinder();
        obj.addNum(num);
        double param_2 = obj.findMedian();
    }
}

class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        double median = findMedian();

        if (maxHeapSize == minHeapSize) {
            if (num > median)
                minHeap.add(num);
            else
                maxHeap.add(num);
        } else if (maxHeapSize > minHeapSize) {
            if (num > median) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
                int temp = maxHeap.poll();
                minHeap.add(temp);
            }
        } else if (maxHeapSize < minHeapSize) {
            if (num < median) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
                int temp = minHeap.poll();
                maxHeap.add(temp);
            }
        }

    }

    public double findMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty())
            return 0;
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        double median = 0;

        if (maxHeapSize == minHeapSize)
            median = (double) (maxHeap.peek() + minHeap.peek()) / (double) 2;
        else if (maxHeapSize > minHeapSize)
            median = maxHeap.peek();
        else
            median = minHeap.peek();
        return median;
    }
}
