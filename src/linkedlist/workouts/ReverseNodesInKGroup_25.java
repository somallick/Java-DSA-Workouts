package src.linkedlist.workouts;

import src.linkedlist.workouts.model.Node;

//https://leetcode.com/problems/reverse-nodes-in-k-group
public class ReverseNodesInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int length = getListLength(head);
        if (length < k)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        int position = 0;
        while (position < k) { // reverse K no. of nodes in LL
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
            position++;
        }
        if (curr != null) {
            ListNode headFromRecursion = reverseKGroup(curr, k);
            head.next = headFromRecursion;
        }
        return prev;
    }

    public static int getListLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
