package src.heap.workouts;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists
public class MergeKSortedLists_23 {

    // Best Sol - TC- m*n log(m*n) SC - O(m)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode finalHead = null, finalTail = null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new NodeComparator());
        // store the all head node for K number of sorted LL
        for (ListNode head : lists) {
            if (head != null)
                minHeap.add(head);
        }
        // store each min node (lets say ith row) in final LL and  push the next node of that ith row
        while (!minHeap.isEmpty()) {
            ListNode front = minHeap.poll();
            if (finalHead == null) {
                finalHead = front;
                finalTail = front;
            } else {
                finalTail.next = front;
                finalTail = front;
            }
            if (front.next != null) {
                minHeap.add(front.next);
            }
            front.next = null;
        }
        return finalHead;
    }

    // To calculate the min element between List Node values in priority queue
    private class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return Integer.compare(o1.val, o2.val);
        }
    }
}
