package src.linkedlist.workouts;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/linked-list-cycle
public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) { // TC O(n) SC O(1) // Tortoise approach - Best Sol
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
                if (fast == slow)
                    return true;
            }
        }
        return false;
    }

    public boolean hasCycle_sol2(ListNode head) { // TC O(n) SC O(n) - Easy sol
        Map<ListNode, Boolean> tracker = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            if (tracker.containsKey(temp))
                return true;
            else
                tracker.put(temp, true);
            temp = temp.next;
        }
        return false;
    }
}
